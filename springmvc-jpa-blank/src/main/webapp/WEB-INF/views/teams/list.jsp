<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="TEAMS LIST" />
    <c:param name="body">
        <p>
            <a href='${pageContext.request.contextPath}/teams/form/' class="btn btn-info">CREATE</a>
        </p>
        <table
            class="table table-striped table-bordered table-condensed">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>MEMBER LIMIT</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${page.content}" var="teams">
                <tr>
                    <td>${f:h(teams.teamId)}</td>
                    <td>${f:h(teams.teamName)}</td>
                    <td>${f:h(teams.teamMemCount)}</td>
                    <td><a
                        href='${pageContext.request.contextPath}/teams/edit/${teams.teamId}'
                        class="btn btn-primary">수정</a> <a
                        href='${pageContext.request.contextPath}/teams/delete/${teams.teamId}'
                        class="btn">삭제</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
        <div class="pagination">
            <ul>
                <li><c:if test="${!page.isFirstPage()}">
                        <a href='<c:url value="?page=0" />'>&laquo;
                            first</a>
                    </c:if></li>
                <li><c:if test="${page.hasPreviousPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number - 1)}" />'>&lt;
                            prev</a>
                    </c:if></li>
                <li><c:if test="${page.hasNextPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number + 1)}" />'>next
                            &gt;</a>
                    </c:if></li>
                <li><c:if test="${!page.isLastPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.totalPages - 1)}" />'>last
                            &raquo;</a>
                    </c:if></li>
            </ul>
        </div>
    </c:param>
</c:import>
