<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <div id="page_nav">
                <a href="${url}&pageNow=1">首页</a>
                <c:if test="${page.pageNow>1}">
                    <a href="${url}&pageNow=${page.pageNow-1}">上一页</a>
                </c:if>
                <c:choose>
                    <c:when test="${page.totalPages <= 5}">
                        <c:set var="begin" scope="page" value="1" />
                        <c:set var="end" scope="page" value="${page.totalPages}" />
                    </c:when>
                    <c:when test="${page.totalPages > 5}">
                        <c:choose>
                            <c:when test="${page.pageNow<=3}">
                                <c:set var="begin" scope="page" value="1" />
                                <c:set var="end" scope="page" value="5" />
                            </c:when>
                            <c:when test="${page.pageNow +2 >=page.totalPages}">
                                <c:set var="begin" scope="page" value="${page.totalPages-4}" />
                                <c:set var="end" scope="page" value="${page.totalPages}" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="begin" scope="page" value="${page.pageNow-2}" />
                                <c:set var="end" scope="page" value="${page.pageNow+2}" />
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                </c:choose>
                <c:forEach begin="${begin}" end="${end}" var="pnum">
                    <c:if test="${pnum == page.pageNow}">
                        <span style="color: blue">【${page.pageNow}】</span>
                    </c:if>
                    <c:if test="${pnum != page.pageNow}">
                        <a href="${url}&pageNow=${pnum}">${pnum}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNow<page.totalPages}">
                    <a href="${url}&pageNow=${page.pageNow+1}">下一页</a>
                </c:if>
                <a href="${url}&pageNow=${page.totalPages}">末页</a>
                共${page.totalPages}页，${page.totalCount}条记录 到第<input value="${page.pageNow}" name="pageNow"
                    id="pn_input" />页
            </div>