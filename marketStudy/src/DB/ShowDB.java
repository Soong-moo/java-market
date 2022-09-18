//package DB;
//
//import java.sql.SQLException;
//
//public class ShowDB {
//	
//	public void show() {
//		Variation var = new Variation();
//		try {			
//			String cmd = "select * from product";
//			
//			var.setSt(var.getCon().createStatement());
//			
//			var.setRs(var.getSt().executeQuery(cmd));
//			
//			while (var.getRs().next()) {
//				String name = var.getRs().getString("name");
//				int price = var.getRs().getInt("price");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
