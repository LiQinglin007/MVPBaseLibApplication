基于[BaseLibApplication](https://github.com/LiQinglin007/BaseLibApplication)的MVP架构

## 更新说明
### v1.0.2 2019-07-31
* BaseActivity/BaseFragment 修改showLoading()和 hineLoading()方法。解决同一个页面同时展示多次loading，取消多次问题。<br>
  适用与同一个页面同时发起多次请求等场景;
* 更新BaseLib依赖库；
### v1.0.1 2019-07-31
* MyPresenterCallBack添加error方法；
* BaseView添加showToast方法；
* 修改BaseBottomActivity方法注释