## spring cloud 灰度发布（金丝雀部署组件）

- 1. spring cloud 版本目前基于 Greenwich.RELEASE
- 2. boot 的版本是2.1.0.RELEASE 版本
- 3. 基于的思路是添加Ribbon路由规则策略，实现灰度实例和正常实例的调度区分
- 4. 灰度发布需要管理功能，则需要控制台进行灰度打标，前端调用通过header来决定调用链路的选择
- 5. FeignClient 方式进行链路调度的header传递
- 6. 本项目不直接依赖官方的springboot parent 依赖， 依赖于dependencies，所以在使用过程中可能存在差异

### hystrix影响获取header 的问题
```$txt
   hystrix 对于每一个服务启动了一个线程池做调用，如果启动了线程池，则其实请求会复制到对应的hystrix 的线程里，
   这时候再去调用ribbon 做负载均衡是获取不到线程变量的，即此时的 RequestContext ，RequestHoder 等使用ThreadLocal
   是无效的。

```