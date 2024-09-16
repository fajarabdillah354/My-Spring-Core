package my.spring.core.aware;

public interface IdAware {

    //jika ada bean yang implement IdAware kita akan setIdnya menjadi unique id
    void setId(String id);

    String getId();

}
