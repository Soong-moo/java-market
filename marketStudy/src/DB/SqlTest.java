package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SqlTest {
	
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	
	public static void main(String[] args){
		// Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
        // java 표준인 java.sql.Connection 클래스를 import해야 한다.
		
		try {
			// 1. 드라이버 로딩
            // 드라이버 인터페이스를 구현한 클래스를 로딩
            // mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
            // mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
            // 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.
            Class.forName("com.mysql.jdbc.Driver");
            
            // 2. 연결하기
            // 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
            // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
            // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
            String url = "jdbc:mysql://localhost/products";

            // @param  getConnection(url, userName, password);
            // @return Connection
            con = DriverManager.getConnection(url, "test", "test");
            System.out.println("연결 성공");
                 
		}
		catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
	}

}
