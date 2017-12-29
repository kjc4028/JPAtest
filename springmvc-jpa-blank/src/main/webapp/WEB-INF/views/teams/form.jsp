<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="TEAMS FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="teams">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="teams"
            cssClass="form-horizontal">
            <fieldset>
                <legend>teams</legend>
                <div class="control-group">
                    <label class="control-label" for="teamName">Team name</label>
                    <div class="controls">
                        <form:input path="teamName" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="teamName"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="teamMemCount">teamMemCount</label>
                    <div class="controls">
                        <form:input path="teamMemCount" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="teamMemCount"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <form:hidden path="teamId" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/teams/list' class="btn">list</a>
    </c:param>
</c:import>

