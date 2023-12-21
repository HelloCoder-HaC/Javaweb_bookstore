# JavaWeb图书销售管理系统/网上书店

Javaweb_bookstore，一个基于servlet+jsp+bootstrap 的MVC图书销售管理系统。

- 可以直接运行
- 可以用做大作业、毕业设计
- 有完整的代码注释

## 1、开发环境：
  Tomcat版本：v8.5
  MySQL版本：v8.0
  JDK:1.8.0_171

（后端没有用到任何框架，都是servlet，比较简单，前端是JSP+bootstrap）

##  2、功能模块

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175643885.png)

## 3、本地开发

### 1、导入sql

找到sql文件，导入到数据库，并且在下一步导入代码后，修改数据库的用户名和密码。

### 2、使用IDEA导入代码

第一步先导入项目，使用eclipse的方式导入，如果不是，那么接下来会复杂，还需要设置src和resources目录。

#### 2.1、清除原来的eclipse信息

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210507225206166.png)

#### 2.2、导入包

如果你不是通过eclipse导入的方式导入项目，这里需要把这些jar手动右击 添加到 library 即可：

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210507225623540.png)

#### 2.3、设置Modules的web.xml文件

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210507230128552.png)

这里主注意两个地方：

- 上方，设置Path的目录，`web.xml`文件要正确
- 下方，设置Web Resource Dictory 是正确的WebRoot 路径，也就是WebContent。

`web.xml` 可以配置首页地址，具体请看文件，修改你需要的首页，第一个是没有自动加载数据的，第二个是加载数据的。

#### 2.4、生成Artifact包

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210507230032298.png)

#### 2.5、配置Tomcat

我这里Tomcat8.0版本有乱码，可以设置一下为`-Dfile.encoding=UTF-8`

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210507230334986.png)

Deployment 不要设置Application context！



### 3、eclipse 

项目带有eclipse 标识，基本上按照以上配置即可。

但是不要使用默认的 context 路径

## 4、功能页面

### 用户端：

首页：

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175143151.png)

商品详情：

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175249476.png)

购物车：

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175226003.png)

### 管理员端：

功能见左侧导航栏：

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175911434.png)

![](https://cdn.jsdelivr.net/gh/DogerRain/image@main/Home/image-20210509175835182.png)





用户账号密码：HaC / 123



管理员账号密码：admin  / 123

## 5、A&Q

1、项目是从其他地方copy过来的二开的，刚拿到这个项目的时候，一堆bug，经过了一系列的重构，功能也比之前多了。

但是`立即购买`的这个模块就没有做了（先通过加入购物车再立即购买就可以了）。。。。，大家可以自己完善一下功能，比如说：

- 用户查看订单
- 立即购买跳转
- 区分是否收藏过



2、关于图片的路径

说实话我现在也搞不懂，大家可以参考`addBook()`的代码实现，什么相对路径、绝对路径，我暂时还不明白，大家可以去看看如何自定义设置自己的图片路径。



## 6、声明|费用

本项目存在文件缺少，且不再提供免费使用，如要获取，请联系本人。

