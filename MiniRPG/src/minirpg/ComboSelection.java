/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minirpg;

/**
 *
 * @author LordShadow
 */
class ComboSelection {
    
    PlayerSummeryPanel PSP = new PlayerSummeryPanel();
    
    private String Role;
    private String Class;
    private String Skill1;
    private String Skill2;
    private String Skill3;
    private String Skill4;
    
    
    public ComboSelection()
    {
        this("Role", "Class", "Skill1", "Skill2", "Skill3", "Skill4");
    }
    
    public ComboSelection(String Role, String Class, String Skill1, String Skill2, String Skill3, String Skill4)
    {
        setRole(Role);
        setclass(Class);
        setSkill1(Skill1);
        setSkill2(Skill2);
        setSkill3(Skill3);
        setSkill4(Skill4);
    }
    
    public String getRole()
    {
        return Role;
    }
    
    
    public String getclass()
    {
        return Class;
    }
    
    public String getSkill1()
    {
        return Skill1;
    }
    
    public String getSkill2()
    {
        return Skill2;
    }
    
    public String getSkill3()
    {
        return Skill3;
    }
    
    public String getSkill4()
    {
        return Skill4;
    }
    
    public void setRole(String Role)
    {
        this.Role = Role;
    }
    
    public void setclass(String Class)
    {
        this.Class = Class;
    }
    
    public void setSkill1(String Skill1)
    {
        this.Skill1 = Skill1;
    }
    
    public void setSkill2(String Skill2)
    {
        this.Skill2 = Skill2;
    }
    public void setSkill3(String Skill3)
    {
        this.Skill3 = Skill3;
    }
    public void setSkill4(String Skill4)
    {
        this.Skill4 = Skill4;
    }
            
            
}
