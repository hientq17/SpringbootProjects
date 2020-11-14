<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="pre.jsp"%>
<!-- A standard form for uploading images to your server -->
<div id='backend_upload'>
    <h1>Upload file</h1>
    <h2>File is uploaded through the server</h2>
    <form:form method="post" action="upload" modelAttribute="fileUpload" enctype="multipart/form-data">
        <div class="form_line">
            <form:label path="title">Title:</form:label>
            <div class="form_controls">
                <form:input path="title"/>
                <form:errors path="title" extraClasses="error" />
            </div>
        </div>

        <c:if test="${empty fileUpload.publicId}">
            <div class="form_line">
                <label for="file">File:</label>
                <div class="form_controls">
                    <input type="file" name="file" id="file"/>
                </div>
            </div>
        </c:if>
        <c:if test="${!empty fileUpload.publicId}">
            <c:if test="${fileUpload.isImage}">
                <div class="form_line">
                    <label>Image:</label>
                    <div class="form_controls">
                        <img src="${fileUpload.thumbnailUrl}"/>
                    </div>
                </div>
            </c:if>
            <c:if test="${!fileUpload.isImage}">
                <div class="form_line">
                    <label>Raw file:</label>
                    <div class="form_controls">
                        <a href="<cl:url storedSrc="${fileUpload}"/>">${fileUpload.publicId}</a>
                    </div>
                </div>
            </c:if>
        </c:if>
        <c:if test="${errorMessage.length()>0}">
            <div class="form_line">
                <div class="form_controls">
                    <p style="color: red">Error: ${errorMessage}</p>
                </div>
            </div>
        </c:if>
        <div class="form_line">
            <div class="form_controls">
                <input type="submit" value="Upload"/>
            </div>
        </div>
        <form:hidden path="preloadedFile"/>
        <form:errors path="signature" extraClasses="error" />
    </form:form>

</div>

<a href="<c:url value="/"/>" class="back_link">Back to list</a>
<%@include file="post.jsp"%>

