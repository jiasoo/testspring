<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring mvc project</title>
<link rel="icon" type="image/x-icon" href="resources/images/favicon.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
	function go_members() {
		location.href ="/members_list.do"
	}
	function go_guestbook() {
		location.href ="/guestbook_list.do"
	}
	function go_guestbook2() {
		location.href ="/guestbook2_list.do"
	}
</script>
<body>
	<button onclick="go_members()">Members</button>
	<button onclick="go_guestbook()">GuestBook</button>
	<button onclick="go_guestbook2()">GuestBook2</button>
	<hr>
	<div id="login" style="margin 30px">
		<form action="">
			<p> ID : <input type="text" name="m_id" required></p>
			<p> PW : <input type="password" name="m_pw" required></p>
			<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>