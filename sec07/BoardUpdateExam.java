package ch20.oracle.sec07;

import java.sql.*;

public class BoardUpdateExam {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "java",
                    "oracle"
            );

            //매개변수화된 SQL 문 작성
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람");
            pstmt.setString(2, "눈으로 만든 사람");
            pstmt.setString(3, "snowman.jpg");
            pstmt.setBlob(4, BoardUpdateExam.class.getResourceAsStream("snowman.jpg"));
            pstmt.setInt(5,3); //boards 테이블에 있는 게시물 번호 (bno) 지정

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수 :" +rows);


            //PreparedStatment 닫기
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    //연결끊기
                    conn.close();
                }catch (SQLException e) {}
            }
        }
    }
}
