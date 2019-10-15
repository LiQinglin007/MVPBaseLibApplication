基于[BaseLibApplication](https://github.com/LiQinglin007/BaseLibApplication)的MVP架构


## Demo
这是一个基于该类库的app<br>
[传送门](https://github.com/LiQinglin007/OpenAppMVP)

## 更新说明
### v1.0.3 2019-08-7
* 更新BaseLib依赖库(v1.0.7)<br>
* base/BaseActivity\BaseFragment类添加showShortToast方法<br>
* 优化model层网络请求模块，添加BaseOkHttpCallBack的子类MiHttpCallBack，在Model模块专注处理onSuccess方法<br>
* 优化Presenter层回调，添加BasePresenterCallBack的子类MiPersenterCallBack，在Presenter的回调中，专注处理onSuccess方法，其他结果通过HttpConfig配置项参数由程序解决<br>
### v1.0.3 2019-08-7
* 更新BaseLib依赖库(v1.0.6)；
### v1.0.2 2019-07-31
* BaseActivity/BaseFragment 修改showLoading()和 hineLoading()方法。解决同一个页面同时展示多次loading，取消多次问题。<br>
  适用与同一个页面同时发起多次请求等场景;
* 更新BaseLib依赖库；
### v1.0.1 2019-07-31
* MyPresenterCallBack添加error方法；
* BaseView添加showToast方法；
* 修改BaseBottomActivity方法注释