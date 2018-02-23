package Entity;

import Entity.ItemType;
import Entity.Orderr;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-23T09:09:28")
@StaticMetamodel(OrderLine.class)
public class OrderLine_ { 

    public static volatile SingularAttribute<OrderLine, ItemType> itemType;
    public static volatile SingularAttribute<OrderLine, Integer> quantity;
    public static volatile SingularAttribute<OrderLine, Long> id;
    public static volatile SingularAttribute<OrderLine, Orderr> order;

}