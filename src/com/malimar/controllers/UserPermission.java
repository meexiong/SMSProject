
package com.malimar.controllers;

import com.malimar.models.UserPermissions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class UserPermission {
    UserPermissions up = new UserPermissions();
    
    public static void getPermission_SDN(String empID, String frm, JLabel btnSave, JLabel btnDelete, JLabel btnNew){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
                if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                    
                }else if ("btnDelete".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnDelete.setVisible(true);
                } else if ("btnDelete".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnDelete.setVisible(false);
                }else if ("btnDelete".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnDelete.setVisible(false);
                }else if ("btnDelete".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnDelete.setVisible(true);
                
                }else if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnNew.setVisible(true);
                } else if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnNew.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getPermission_SD(String empID, String frm, JLabel btnSave, JLabel btnDelete){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
                if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                    
                }else if ("btnDelete".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnDelete.setVisible(true);
                } else if ("btnDelete".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnDelete.setVisible(false);
                }else if ("btnDelete".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnDelete.setVisible(false);
                }else if ("btnDelete".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnDelete.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getPermission_S(String empID, String frm, JLabel btnSave){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
                if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getPermission_SN(String empID, String frm, JLabel btnSave, JLabel btnNew){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
                if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnSave".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnSave".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                    
                }else if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnNew.setVisible(true);
                } else if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnNew.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getPermission_N(String empID, String frm, JLabel btnNew){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
               if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnNew.setVisible(true);
                } else if ("btnNew".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnNew.setVisible(false);
                }else if ("btnNew".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnNew.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getPermission_P(String empID, String frm, JLabel btnPay){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
               if ("btnPay".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnPay.setVisible(true);
                } else if ("btnPay".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnPay.setVisible(false);
                }else if ("btnPay".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnPay.setVisible(false);
                }else if ("btnPay".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnPay.setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void getPermission_UserLogin(String empID, String frm, JLabel btnSave){
        try {
            String ObjectMenu;
            int Write;
            int Deny;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_Permission " + frm + "," + empID + "";
            ResultSet rs = c.createStatement().executeQuery(sql);
             while (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                Deny = rs.getInt("Denys");
                if ("btnShowData".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnShowData".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowData".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowData".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnGroupShowData".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnGroupShowData".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnGroupShowData".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroup".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowDataGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnUpdateGroupPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnShowFormData".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnShowFormData".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowFormData".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowFormData".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnDataEmployee".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnDataEmployee".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnDataEmployee".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnDataEmployee".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnAddGroup".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnAddGroup".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnAddGroup".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnAddGroup".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("btnShowPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("btnShowPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("btnShowPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabUser".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabUser".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabUser".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabUser".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabCreateGroup".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabCreateGroup".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabCreateGroup".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabCreateGroup".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabAddGroupToLang".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabAddGroupToLang".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabAddGroupToLang".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabAddGroupToLang".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabGrouptoPermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabGrouptoPermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabGrouptoPermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabGrouptoPermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabEmployeetoGroup".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabEmployeetoGroup".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabEmployeetoGroup".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabEmployeetoGroup".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }else if ("TabEmployeePermission".equals(ObjectMenu) && Write == 0 && Deny == 1) {
                    btnSave.setVisible(true);
                } else if ("TabEmployeePermission".equals(ObjectMenu) && Write == 0 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabEmployeePermission".equals(ObjectMenu) && Write == 1 && Deny == 0) {
                    btnSave.setVisible(false);
                } else if ("TabEmployeePermission".equals(ObjectMenu) && Write == 1 && Deny == 1) {
                    btnSave.setVisible(true);
                }          
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getPermission_UserAllForm(String empID, String frm, UserPermissions up, String item){
        try {
            String ObjectMenu;
            int Write;
            Connection c = DatabaseManagerSQL.getConnection();
            String sql = "exec pd_permission_Tab @teachernbr = "+ empID +", @frm = "+ frm +", @Sys_Name = "+ item +"";
            ResultSet rs = c.createStatement().executeQuery(sql);
             if (rs.next()) {
                ObjectMenu = rs.getString("Sys_Name");
                Write = rs.getInt("Write");
                up.setW(Write);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
