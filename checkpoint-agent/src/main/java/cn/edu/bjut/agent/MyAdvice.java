package cn.edu.bjut.agent;

import cn.edu.bjut.agent.track.TrackContext;
import cn.edu.bjut.agent.track.TrackManager;
import cn.edu.bjut.utils.IdMakerUtil;
import net.bytebuddy.asm.Advice;

public class MyAdvice {
    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) {
        String linkId = TrackManager.getCurrentSpan();
        if (null == linkId) {
            linkId = IdMakerUtil.make32Id();
            TrackContext.setLinkId(linkId);
        }
        String entrySpan = TrackManager.createEntrySpan();
        System.out.println("链路追踪：" + entrySpan + " " + className + "." + methodName);

    }

    @Advice.OnMethodExit()
    public static void exit(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) {
        TrackManager.getExitSpan();
    }

}
