package com.ifarm.console.shared.define;

/**
 *
 **/
public enum  HttpResponseCode {
    HTTP_REQUST_ERROR(400,"错误请求"),
    HTTP_Unauthorized(401,"未授权，请重新登录"),
    HTTP_ACCESS_DENIED(403,"拒绝访问"),
    HTTP_resource_NOTFIND(404,"请求错误,未找到该资源"),
    HTTP_METHOD_NOTALLOW(405,"请求方法未允许"),
    HTTP_REQUEST_TIMEOUT(408,"请求超时"),
    HTTP_SERVICE_ERROR(500,"服务器端出错"),
    HTTP_Network_unrealized(501,"网络未实现"),
    HTTP_NETWORK_ERROR(502,"网络错误"),
    HTTP_SERVICE_available(503,"服务不可用"),
    HTTP_NETWORK_TIMEOUT(504,"网络超时"),
    HTTP_VERSION_NOT_SUPPORT(505,"http版本不支持该请求")
    ;

    private int code;
    private String message;

    private HttpResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
