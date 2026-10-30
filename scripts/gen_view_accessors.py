#!/usr/bin/env python3
"""Тип свойства не объявляется явно: findViewById даёт platform-тип (T!), как у
kotlin-android-extensions; id, которых нет в части layout (планшетные), могут быть null.

Генерирует app/src/main/java/org/linhome/synthetic/ViewAccessors.kt из layout-XML.

Замена удалённому kotlin-android-extensions: для каждого layout создаются
extension-свойства findViewById в пакетах org.linhome.synthetic.<layout> (Activity,
Fragment, Dialog) и org.linhome.synthetic.<layout>.view (View).
Запуск из корня репозитория: python3 scripts/gen_view_accessors.py
"""
import glob, os, shutil
import xml.etree.ElementTree as ET

ANDROID = '{http://schemas.android.com/apk/res/android}'
VIEW_PKG = {'View': 'android.view.View', 'ViewGroup': 'android.view.ViewGroup',
            'TextureView': 'android.view.TextureView', 'SurfaceView': 'android.view.SurfaceView',
            'WebView': 'android.webkit.WebView'}
GENERIC = {'fragment', 'include', 'merge', 'FragmentContainerView'}


def cls(tag):
    """Класс view по имени тега layout-XML."""
    if tag in GENERIC:
        return 'android.view.View'
    if '.' in tag:
        return tag
    return VIEW_PKG.get(tag, 'android.widget.' + tag)


layouts = {}
for f in sorted(glob.glob('app/src/main/res/layout*/*.xml')):
    name = os.path.splitext(os.path.basename(f))[0]
    ids = layouts.setdefault(name, {})
    for el in ET.parse(f).getroot().iter():
        i = el.attrib.get(ANDROID + 'id')
        if i and i.startswith('@+id/'):
            c = cls(el.tag)
            n = i[5:]
            ids[n] = c if ids.get(n, c) == c else 'android.view.View'

files = {}
for name, ids in layouts.items():
    if not ids:
        continue
    base = 'org.linhome.synthetic.' + name
    body = ['package %s' % base, '', 'import android.app.Activity', 'import android.app.Dialog', 'import android.view.View',
            'import androidx.fragment.app.Fragment', '']
    for n, c in sorted(ids.items()):
        body.append('val Activity.%s get() = findViewById<%s>(org.linhome.R.id.%s)' % (n, c, n))
        body.append('val Dialog.%s get() = findViewById<%s>(org.linhome.R.id.%s)' % (n, c, n))
        body.append('val Fragment.%s get() = requireView().findViewById<%s>(org.linhome.R.id.%s)' % (n, c, n))
    files[base.replace('.', '/') + '/Accessors.kt'] = '\n'.join(body) + '\n'
    vb = ['package %s.view' % base, '', 'import android.view.View', '']
    for n, c in sorted(ids.items()):
        vb.append('val View.%s get() = findViewById<%s>(org.linhome.R.id.%s)' % (n, c, n))
    files[base.replace('.', '/') + '/view/Accessors.kt'] = '\n'.join(vb) + '\n'

root = 'app/src/main/java/'
shutil.rmtree(root + 'org/linhome/synthetic', ignore_errors=True)
for p, t in files.items():
    os.makedirs(os.path.dirname(root + p), exist_ok=True)
    open(root + p, 'w').write(t)
print(len(files), 'files')
