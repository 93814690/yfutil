package top.liyf.core.observer;

/**
 * @author liyf
 * Created in 2019-04-28
 */
public interface Subject {

    /**
     * 功能描述: 注册观察者
     *
     * @param o 观察者
     * @author liyf
     */
    void registerObserver(Observer o);

    /**
     * 功能描述: 删除观察者
     *
     * @param o 观察者
     * @author liyf
     */
    void removeObserver(Observer o);

    /**
     * 功能描述: 通知所有的观察者
     *
     * @author liyf
     */
    default void notifyObserver() {
        notifyObserver(null);
    }

    /**
     * 功能描述: 通知所有的观察者
     *
     * @param arg 推送的数据
     * @author liyf
     */
    void notifyObserver(Object arg);

    /**
     * 功能描述: 标记被观察者对象已经改变
     *
     * @author liyf
     */
    void setChanged();

    /**
     * 功能描述:清除改变状态
     *
     * @author liyf
     */
    void clearChanged();

    /**
     * 功能描述: 查询被观察者对象是否改变
     *
     * @return boolean
     * @author liyf
     */
    boolean hasChanged();
}
