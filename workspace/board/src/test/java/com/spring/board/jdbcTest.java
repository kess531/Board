package com.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class jdbcTest {


static {

try {

Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (Exception e) {

e.printStackTrace();

}

}
@Test

public void testConnection() {

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";

String uid = "boardOrcl"; // 사용자 계정명

String upass = "orcl1234"; // 해당 계정 비밀번호
try {
conn = DriverManager.getConnection(url, uid, upass);

stmt = conn.createStatement();

rs = stmt.executeQuery("select * from member");

if (rs.next()) {

System.out.println("연결 확인");

}

} catch (Exception e) {

e.printStackTrace();

} finally {

try {

rs.close();

stmt.close();

conn.close();
} catch (Exception e) {
e.printStackTrace();
}
} // 연결 확인
}// 테스트 메소드

}
package com.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class jdbcTest {


static {

try {

Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (Exception e) {

e.printStackTrace();

}

}
@Test

public void testConnection() {

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";

String uid = "boardOrcl"; // 사용자 계정명

String upass = "orcl1234"; // 해당 계정 비밀번호
try {
conn = DriverManager.getConnection(url, uid, upass);

stmt = conn.createStatement();

rs = stmt.executeQuery("select * from member");

if (rs.next()) {

System.out.println("연결 확인");

}

} catch (Exception e) {

e.printStackTrace();

} finally {

try {

rs.close();

stmt.close();

conn.close();
} catch (Exception e) {
e.printStackTrace();
}
} // 연결 확인
}// 테스트 메소드

}
package com.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class jdbcTest {


static {

try {

Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (Exception e) {

e.printStackTrace();

}

}
@Test

public void testConnection() {

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";

String uid = "boardOrcl"; // 사용자 계정명

String upass = "orcl1234"; // 해당 계정 비밀번호
try {
conn = DriverManager.getConnection(url, uid, upass);

stmt = conn.createStatement();

rs = stmt.executeQuery("select * from member");

if (rs.next()) {

System.out.println("연결 확인");

}

} catch (Exception e) {

e.printStackTrace();

} finally {

try {

rs.close();

stmt.close();

conn.close();
} catch (Exception e) {
e.printStackTrace();
}
} // 연결 확인
}// 테스트 메소드

}
package com.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class jdbcTest {


static {

try {

Class.forName("oracle.jdbc.driver.OracleDriver");

} catch (Exception e) {

e.printStackTrace();

}

}
@Test

public void testConnection() {

Connection conn = null;

Statement stmt = null;

ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";

String uid = "boardOrcl"; // 사용자 계정명

String upass = "orcl1234"; // 해당 계정 비밀번호
try {
conn = DriverManager.getConnection(url, uid, upass);

stmt = conn.createStatement();

rs = stmt.executeQuery("select * from member");

if (rs.next()) {

System.out.println("연결 확인");

}

} catch (Exception e) {

e.printStackTrace();

} finally {

try {

rs.close();

stmt.close();

conn.close();
} catch (Exception e) {
e.printStackTrace();
}
} // 연결 확인
}// 테스트 메소드

}
