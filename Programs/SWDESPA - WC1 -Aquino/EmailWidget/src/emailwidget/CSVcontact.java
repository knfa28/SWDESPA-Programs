package emailwidget;

public class CSVcontact {  
    private String name;  
    private String age;  
    private String gender;  
    private String workPlace;  
    private String job;  

    public String getName() {  
     return name;  
    }  

    public void setName(String name) {  
     this.name = name;  
    }  

    public String getAge() {  
     return age;  
    }  

    public void setAge(String age) {  
     this.age = age;  
    }  

    public String getGender() {  
     return gender;  
    }  

    public void setGender(String gender) {  
     this.gender = gender;  
    }  

    public String getWorkPlace() {  
     return workPlace;  
    }  

    public void setWorkPlace(String workPlace) {  
     this.workPlace = workPlace;  
    }  

    public String getJob() {  
     return job;  
    }  

    public void setJob(String job) {  
     this.job = job;  
    } 
    
    public String toString(){
        return "<html>" + name
                + "<br/>" + job
                + "<br/" + workPlace + "<br/> <br/> </html>";
    }
}  