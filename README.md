# ApiGenerator
auto generator for some api

## 简介
使用retrofit+Rxjava的框架时发现大量接口的书写模板化。故按照平时书写的规律。
实现了一个自动生成 service文件、requestParam文件、及response文件的代码生成器
##实现

* 尝试了Groovy来实现代码。
    Groovy作为基于JVM的语言。和java无缝连接。其本身提供更加简洁的API。在初尝它便利的同时，也为为它的简洁惊叹。
    
* 使用javaPoet生成java文件的代码
    基本上沿袭了之前写Apt的套路。
    
## 不足

* 不能通过网址自动抓取到地址。只能手动抓到地址
* 依赖于api文档的正确性才能生成正确的代码。生成器中并未做大量的效验。
* 暂无图形化界面     
