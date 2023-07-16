@[toc]
## 快速开始
###  快速实现一个模块的CRUD

> 以下mp代指MyBatis-Plus

#### 创建数据库表

> 嘿，大家好，今天我想和大家分享一下在数据库设计中的一些经验和技巧。在开发过程中，我们通常会按照前端菜单栏的一级菜单来划分模块，例如系统管理模块为"sys"，权限管理模块为"auth"，而在系统管理模块下面的租户管理将对应建立一张名为"sys_tenant"的数据表。

> 为了避免表名过长，我们可以采用缩写方式进行命名，但我们也要注意不要过于简写，表名应该清晰易懂。此外，我们建议采用"所属模块名_表名"的方式来命名表，例如"sys_tenant"，并且所有的列名如果包含多个单词，也应该按照下划线分割的形式进行命名。

> 在设计主键列时，我们可以使用"id"作为列名，并将其设置为主键和varchar类型。由于我们采用了MP的UUID方式自动生成ID值，因此不需要设置自增，在实体类中也不需要显式地设置ID值。

> 在建立表时，我们还应该提供完善的表名和列名注释，这将方便代码生成模板自动生成类和字段注释。如果有枚举类注释，建议按照"列名中文注释#枚举值1=枚举值1中文|枚举值2=枚举值2中文"的格式进行注释，这样在生成代码时，会根据列名和字段名自动生成枚举类，并将枚举值对应的中文自动翻译成英文字段名

>最后，我们还必须确保所有表都包含"create_time"、"update_time"、"create_user"和"update_user"这几个列名。由于我们的项目实现了MP的字段自动填充功能，MP会自动维护这些字段的值，从而提高了代码的可读性和可维护性


最新执行你的sql,例如下面租户管理的sql

```sql
create table if not exists sys_tenant
(
	id varchar(255) not null comment '租户id'
		primary key,
	name varchar(255) null comment '租户名称',
	code varchar(64) null comment '租户编号',
	start_time datetime null comment '开始时间',
	end_time datetime null comment '结束时间',
	update_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	status int default 0 not null comment '状态#0=正常|1=冻结',
	tenant_id varchar(255) null comment '租户id',
	create_user varchar(100) null comment '创建人',
	update_user varchar(100) null comment '修改人'
)
comment '租户表' collate=utf8mb4_bin;

```
#### 执行代码生成器
 
 2. 运行`yiyuan-plugins-mp`模块的`CodeGenerator`工具类，按照响应的提示信息填写完即可生成后端相关代码

> 提示信息该如何正确填写
> 1：请输入模块名 -->所属菜单一级模块的英文名称,例如系统管理`sys`

> 2：请输入根包名-->根据你的工程模块是`yiyuan-core-sys`那么你的根包名应该`net.yiyuan.core.sys`,如果模块是`yiyuan-plugins-mp`那么你的模块的根包名是应该是`net.yiyuan.plugins.mp`

> 3：请输入作者名称 -->用于自动生成代码注释的作者

> 4：请输入表名，多个英文逗号分割-->假设你的一级模块有多个二级模块，也就是对应多张表，那么你可以一次性填写多个表名，用逗号分割开，就可以一次性生成所有子模块的crud了，当然你也可以选择每次一个一个生成，每次把生成src目录覆盖工程的src的目录就可以

> 5：请输入apiFox接口一级模块名称 * 例如系统管理--->就是填写你前端对应的一级菜单的中文名称,二级模块的中文名称 是根据表名的注释来生成的（表名的注释规范 租户管理表  就按照前端二级菜单名称来就行）

> 6：运行完成以后会在顶层父工程下面生成一个src目录 ，将这个src复制到你的工程模块里面，然后在idea中右键你的工程模块选择`Reformt Code`，格式美化一下自动生成的代码就完成代码生成了
 
![在这里插入图片描述](https://img-blog.csdnimg.cn/fa9b190ebe5e4bbcad9ddcde6c17bedd.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/e9dc3ff2a49d4a9f8724c120022dfea6.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/941ab8564d7648e28c88f85baf1f0a56.png)

 #### 引入依赖到主模块,并且同步上传接口
 
 在主工程`yiyuan-admin`中pom.xml将刚才代码生成的`yiyuan-core-sys`模块加上,启动项目就可以访问了系统管理模块相关的crud接口了
![在这里插入图片描](https://img-blog.csdnimg.cn/dd7c23b5c60e4bed80360c67d52940ca.png)
#### 同步接口到apifox接口工具上

> 为什么项目采用apifox，而不用swgger?
> 因为swgger有的功能他全有,他有的功能swgger没有,并且apixfox对代码侵入性很小，不像swgger一样需要每个类每个方法都要加上swgger的注解，apifox只要你的类注释和方法注释按照统一格式来就可以轻松完成接口上传，并且实现团队内同步写作更新调试文档，类似于腾讯文档一样，即改即用

1:在idea中安装apifox插件,参考官方链接[官方安装插件说明](https://apifox.com/help/applications-and-plugins/idea/start#%E5%AE%89%E8%A3%85)

2:在一源的项目中生成的代码的controller层类注释和方法注释已经完美兼容apifox,所以直接右键你的工程模块，选择upload apifox就可以上传到接口

	

