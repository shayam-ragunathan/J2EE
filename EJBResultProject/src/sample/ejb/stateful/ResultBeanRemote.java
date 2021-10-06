package sample.ejb.stateful;

import javax.ejb.Remote;

@Remote
public interface ResultBeanRemote {
    void setData(String name,int mark1,int mark2,int mark3);
    void calculateTotal();
    void calculatePersentage();
    String getResult();
    void delete();
}
