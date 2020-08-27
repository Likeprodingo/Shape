<html>
<head>
    <title>UPLOAD PAGE</title>
</head>
<body>
Uploads
<form action="upload" enctype="multipart/form-data" method="POST">
    Upload File: <INPUT type="file" name="content" height="130" accept="text" multiple>
    <INPUT type="submit" value="upload">
</form>
<form action="controller" method = "post">
    <input type="hidden" name = "command" value="files">
    <INPUT type="submit" value="files">
</form>
</body>
</html>