<%@page language="java" pageEncoding="UTF-8"%>
<%-- Импортировать JSTL-библиотеку --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Импортировать собственную библиотеку тегов --%>
<%@taglib prefix="ad" uri="http://lab9.by/tags"%>
<%-- Извлечь JavaBean требуемого объявления --%>
<ad:getAds id="${param.id}" var="ad" />
<%-- Удалить его из системы --%>
<ad:deleteAd ad="${ad}" />
<%-- Переадресовать на страницу кабинета --%>
<c:redirect url="/cabinet.jsp" />
