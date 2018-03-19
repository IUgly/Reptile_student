package org;

/**
 * @author ugly
 */
public class InsertData {
    public void InsertInfo(String info){
        MySql ms = new MySql();
        DataStructure ds = new DataStructure();

        String sql = "Insert into cqupt values (\"" +"\"" + ds.name + "\")";
        ms.datatoMySql(sql);
    }
}
