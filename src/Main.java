import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	public static void main(String [] args) {
		Connection con = null;
		try {
			// SQLite JDBC check
			Class.forName("org.sqlite.JDBC");
						
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			
			// 데이터 추가
			System.out.println("=== 데이터 추가 ===");
			Statement stat2 = con.createStatement();
			
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('방탄소년단','남성','2010년대','2013년',datetime('now','localtime'));";
			String sql3 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('아이유','여성','2000년대','2000년',datetime('now','localtime'));;";
			String sql4 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('트와이스','여성','2002년대','2002년',datetime('now','localtime'));";
			String sql5 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('NCT','남성','2009년대','2009년',datetime('now','localtime'));";
			String sql6 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('거미','여성','1990년대','1990년',datetime('now','localtime'));";
			
			int cnt2 = stat2.executeUpdate(sql2);
			if(cnt2>0) {
				System.out.println("새로운 데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			stat2.close();
			
			int cnt3 = stat2.executeUpdate(sql3);
			if(cnt3>0) {
				System.out.println("새로운 데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			stat2.close();
			
			int cnt4 = stat2.executeUpdate(sql4);
			if(cnt4>0) {
				System.out.println("새로운 데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			stat2.close();
			
			int cnt5 = stat2.executeUpdate(sql5);
			if(cnt5>0) {
			System.out.println("새로운 데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			stat2.close();
			
			int cnt6 = stat2.executeUpdate(sql6);
			if(cnt6>0) {
				System.out.println("새로운 데이터가 추가되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 추가 오류!");
			}
			stat2.close();
	

			
			// 데이터 조회
			System.out.println("\n === 데이터 조회 ===");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists";
			ResultSet rs1 = stat1.executeQuery(sql1);
			while(rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				String a_type = rs1.getString("a_type");
				String a_year = rs1.getString("a_year");
				String debut = rs1.getString("debut");
				String regdate = rs1.getString("regdate");
				System.out.println(id+". "+ name + " " + a_type + " "+ a_year + " "+ debut + " "+ regdate);
			}
			stat1.close();
			
			
			
			// 데이터 수정
			System.out.println("=== 데이터 수정 ===");
			Statement stat3 = con.createStatement();
			String sql8 = "update g_artists set a_year = '2020년대'" + "where id=21;";
			int cnt8 = stat3.executeUpdate(sql8);
			if(cnt8>0) {
				System.out.println("데이터가 정상적으로 수정되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 수정 오류!");
			}
			stat3.close();
			
			
			// 데이터 삭제
			System.out.println("=== 데이터 삭제 ===");
			Statement stat4 = con.createStatement();
			String sql7 = "delete from g_artists where id=25;";

			int cnt7 = stat4.executeUpdate(sql7);
			if(cnt7>0) {
				System.out.println("데이터가 정상적으로 삭제되었습니다!");
			}
			else {
				System.out.println("[Error] 데이터 삭제 오류!");
			}
			stat4.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(Exception e) {}
			
			}
		}
	}
}
