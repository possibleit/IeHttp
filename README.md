# IeHttp
封装好的android网络请求工具类
---
#### 使用方法：
1. 将lehttp包下的文件复制到项目中
2. 根据api返回的json数据，使用GSONFormat构造一个JavaBean类
3. 在需要的地方调用LeHttp.sendJsonRequest(url, requestData, ResposeCals javaBean.class, listener)方法  
参数分别为url 请求的api  
requestdata 请求参数  
ResposeCalss javaBean类，在请求成功后会返回一个  
listener 回调接口  


目前只实现了jsonRequest,如需要使用类似于xmlRequest，请自定义一个实现了LeHttpRequest的类  
需要添加请求参数请在JsonHttpRequest类中添加
