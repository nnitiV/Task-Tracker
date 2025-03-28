<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="task" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<task:head />
</head>
<body>
	<task:header />
	<main>
		<table>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<form:form action="/update_task" method="POST"
							modelAttribute="task">
							<form:hidden path="id" value="${task.id}" />
							<td class="task-name"><form:input path="taskName" value="${task.taskName}" /></td>
							<td class="task-buttons">
								<input type="submit" name="update" value="Update task" />
								<a class="test" href="delete_task?task_id=${task.id}">Delete task</a>
							</td>
						</form:form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/" method="POST" modelAttribute="task" id="action-form">
			<form:input path="taskName" />
			<input type="submit" name="save" value="Save" />
		${error}
	</form:form>
	</main>
</body>
</html>