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
						
			// SQLite �����ͺ��̽� ���Ͽ� ����
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			
			// ������ �߰�
			System.out.println("=== ������ �߰� ===");
			Statement stat2 = con.createStatement();
			
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('��ź�ҳ��','����','2010���','2013��',datetime('now','localtime'));";
			String sql3 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('������','����','2000���','2000��',datetime('now','localtime'));;";
			String sql4 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('Ʈ���̽�','����','2002���','2002��',datetime('now','localtime'));";
			String sql5 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('NCT','����','2009���','2009��',datetime('now','localtime'));";
			String sql6 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values('�Ź�','����','1990���','1990��',datetime('now','localtime'));";
			
			int cnt2 = stat2.executeUpdate(sql2);
			if(cnt2>0) {
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ �߰� ����!");
			}
			stat2.close();
			
			int cnt3 = stat2.executeUpdate(sql3);
			if(cnt3>0) {
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ �߰� ����!");
			}
			stat2.close();
			
			int cnt4 = stat2.executeUpdate(sql4);
			if(cnt4>0) {
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ �߰� ����!");
			}
			stat2.close();
			
			int cnt5 = stat2.executeUpdate(sql5);
			if(cnt5>0) {
			System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ �߰� ����!");
			}
			stat2.close();
			
			int cnt6 = stat2.executeUpdate(sql6);
			if(cnt6>0) {
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ �߰� ����!");
			}
			stat2.close();
	

			
			// ������ ��ȸ
			System.out.println("\n === ������ ��ȸ ===");
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
			
			
			
			// ������ ����
			System.out.println("=== ������ ���� ===");
			Statement stat3 = con.createStatement();
			String sql8 = "update g_artists set a_year = '2020���'" + "where id=21;";
			int cnt8 = stat3.executeUpdate(sql8);
			if(cnt8>0) {
				System.out.println("�����Ͱ� ���������� �����Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ ���� ����!");
			}
			stat3.close();
			
			
			// ������ ����
			System.out.println("=== ������ ���� ===");
			Statement stat4 = con.createStatement();
			String sql7 = "delete from g_artists where id=25;";

			int cnt7 = stat4.executeUpdate(sql7);
			if(cnt7>0) {
				System.out.println("�����Ͱ� ���������� �����Ǿ����ϴ�!");
			}
			else {
				System.out.println("[Error] ������ ���� ����!");
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
