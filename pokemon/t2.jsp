<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pokemon.Pokemon, java.util.List"%>
<%
	List<Pokemon> all = (List<Pokemon>) session.getAttribute("all");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD操作</title>
</head>
<body>
	<P>Create(データの生成)</P>
	<form action="/s1732126/T2" method="POST">
		番号: <input type="text" name="number"> 名前: <input type="text"
			name="name"> 攻撃力: <input type="text" name="attack"> <input
			type="hidden" name="action" value="create"> <input
			type="submit" value="登録">
	</form>
	<hr>
	<P>Read(データの読み取り)</P>
	<%
		for (Pokemon pokemon : all) {
	%>
	<%=pokemon.getNumber()%>,
	<%=pokemon.getName()%>,
	<%=pokemon.getAttack()%>
	<br>
	<%
		}
	%>
	<hr>
	<P>Update(データの更新)</P>
	<form action="/s1732126/T2" method="POST">
		番号: <input type="text" name="number">
		名前: <input type="text" name="name">
		攻撃力: <input type="text" name="attack"> <input type="hidden" name="action" value="update"> <input type="submit" value="更新">
	</form>
	<hr>
	<P>Delete(データの削除)</P>
	<form action="/s1732126/T2" method="POST">
		番号: <input type="text" name="number"> <input type="hidden" name = "action" value="delete"> <input type="submit" value="削除">
	</form>
</body>
</html>

