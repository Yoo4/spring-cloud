service-center port:8761

user-center port:8780

feign-service:8770
zuul-service :8771
config-service:8772
auth-service:8773


Zuul过滤器场景
身份认证PreFilter   异常处理ErrorFilter
服务器耗时统计 PostFilter  动态路由 RouteFilter

本例的访问路径为localhost:8771/api/b/test   从网关进去