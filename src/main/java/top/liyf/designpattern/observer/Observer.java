package top.liyf.designpattern.observer;

/**
 * @author liyf
 * Created in 2019-04-28
 */
public interface Observer {

    /**
     * 功能描述:
     *
     * @param subject 被观察者
     * @param arg 参数
     * @author liyf
     */
    void update(Subject subject, Object arg);
}
