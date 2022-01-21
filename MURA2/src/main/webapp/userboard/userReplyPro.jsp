<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.MemberDAO, reply.model.ReplyDAO, reply.model.ReplyVO" %>

<%
String id_mem = (String) session.getAttribute("loginID");
request.setCharacterEncoding("utf-8");

int pageNum = Integer.parseInt(request.getParameter("pageNum"));
String content_reply = (String) request.getParameter("content_reply");
int board_reply = Integer.parseInt(request.getParameter("board_reply"));

MemberDAO dao = new MemberDAO();
String nn_reply = dao.getMember(id_mem).getNn_mem();
int mem_reply = dao.getMember(id_mem).getUn_mem();

ReplyVO replyVO = new ReplyVO();
replyVO.setNn_reply(nn_reply); replyVO.setMem_reply(mem_reply);
replyVO.setContent_reply(content_reply); replyVO.setBoard_reply(board_reply);
ReplyDAO replyDAO = new ReplyDAO();
replyDAO.insertReply(replyVO, board_reply);
%>

<meta http-equiv="Refresh" content="0;url=/MURA2/userboard/userContent.mur?idx_ut=<%= board_reply%>&pageNum=<%= pageNum%>">
