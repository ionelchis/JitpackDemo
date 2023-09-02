# JitpackDemo

Example on how to publish an android BOM multi-module library to jitpack.


Final product: use only bom version to fetch modules
```
implementation platform('com.github.ionelchis.JitpackDemo:bom:1.0.6')
implementation 'com.github.ionelchis.JitpackDemo:lib1'
implementation 'com.github.ionelchis.JitpackDemo:lib2'
```
