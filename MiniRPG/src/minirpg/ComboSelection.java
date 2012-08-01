/*token change
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
    private String Skill;
    
    public ComboSelection()
    {
        this("Role", "Class", "Skill");
    }
    
    public ComboSelection(String Role, String Class, String Skill)
    {
        setRole(Role);
        setclass(Class);
        setSkill(Skill);
    }
    
    public String getRole()
    {
        return Role;
    }
    
    
    public String getclass()
    {
        return Class;
    }
    
    public String getSkill()
    {
        return Skill;
    }
    
    public void setRole(String Role)
    {
        this.Role = Role;
    }
    
    public void setclass(String Class)
    {
        this.Class = Class;
    }
    
    public void setSkill(String Skill)
    {
        this.Skill = Skill;
    }
            
            
}
