package com.example.fs.service;

import com.example.fs.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @FeignClient  指定调用的服务提供者  microServiceProductProvider
 * Feign 会从Eureka注册中心获取服务名为 microServiceProductProvider 的服务列表(因为负载均衡会部署多个相同服务名在不同服务器上)
 * 通过负载均衡算法进行服务调用(因为集成了Ribbon技术，Feign 便也有了负载均衡算法)
 *
 *  Feign 集成了熔断器 Hystrix 作用：
 *        微服务中服务与服务间通常有依赖关系，用户调商品、商品高库存，库存高订单，一旦一个服务挂了，可能出现线程阻塞，导致线程阻塞
 *        和响应时间过长或不可用，此时如果有大量的请求涌入，容器的线程资源会被消耗完毕，导致服务瘫痪，这就是服务故障的“雪崩效应”
 *        为解决这个问题，就有了熔断器：
 *        如下 fallback = ProductClientServiceFallBack.class 就是熔断器作用类，具体查看 类里注释说明
 *
 *
 * Feign注意事项：
 *      SpringCloud对Feign进行了增强兼容了SpringMVC的注解，我们在使用SpringMVC的注解时需要注意：
 *         @FeignClient 接口方法有基本类型参数在参数必须加@PathVariable("XXX")或@RequestParam("XXX")
 *         @FeignClient 接口方法返回值为复杂对象时，此类型必须有无参构造方法
 */
@FeignClient(value = "microServiceProductProvider", fallback = ProductClientServiceFallBack.class)
public interface ProductClientService {

    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    Product get(@PathVariable("id")  Long id);
}
