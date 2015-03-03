/*  1:   */ package sia.bql.bean.seguridad;
/*  2:   */ 
/*  3:   */ import java.util.List;
/*  4:   */ import javax.faces.application.Application;
/*  5:   */ import javax.faces.context.ExternalContext;
/*  6:   */ import javax.faces.context.FacesContext;
/*  7:   */ import javax.faces.el.ValueBinding;
/*  8:   */ import javax.faces.event.PhaseEvent;
/*  9:   */ import javax.faces.event.PhaseId;
/* 10:   */ import javax.faces.event.PhaseListener;
/* 11:   */ import org.apache.commons.logging.Log;
/* 12:   */ import org.apache.commons.logging.LogFactory;
/* 13:   */ import sia.bql.hibernate.sioperan.IdtUsers;
/* 14:   */ import sia.bql.hibernate.sioperan.IdtUsersDAO;
/* 15:   */ 
/* 16:   */ public class AuthenticationListener
/* 17:   */   implements PhaseListener
/* 18:   */ {
/* 19:23 */   private static final IdtUsersDAO daoUsuarios = new IdtUsersDAO();
/* 20:   */   private static final long serialVersionUID = 1L;
/* 21:25 */   private final Log log = LogFactory.getLog(getClass());
/* 22:   */   
/* 23:   */   public void afterPhase(PhaseEvent e) {}
/* 24:   */   
/* 25:   */   public void beforePhase(PhaseEvent e)
/* 26:   */   {
/* 27:   */     try
/* 28:   */     {
/* 29:31 */       FacesContext context = e.getFacesContext();
/* 30:32 */       String userName = context.getExternalContext().getRemoteUser();
/* 31:33 */       if (userName == null) {
/* 32:34 */         return;
/* 33:   */       }
/* 34:35 */       List l = daoUsuarios.findByUsrName(userName);
/* 35:36 */       if (l.isEmpty())
/* 36:   */       {
/* 37:37 */         this.log.error("Usuario no reconocido o inválido en IDT_USERS: " + userName);
/* 38:38 */         return;
/* 39:   */       }
/* 40:40 */       AuthenticationBean au = (AuthenticationBean)context.getApplication().createValueBinding("#{Authentication}").getValue(context);
/* 41:41 */       au.setUserName(userName);
/* 42:42 */       IdtUsers u = (IdtUsers)l.get(0);
/* 43:43 */       au.setUserId(u.getUsrId());
/* 44:   */     }
/* 45:   */     catch (Throwable t)
/* 46:   */     {
/* 47:45 */       t.printStackTrace();
/* 48:   */     }
/* 49:   */   }
/* 50:   */   
/* 51:   */   public PhaseId getPhaseId()
/* 52:   */   {
/* 53:49 */     return PhaseId.RESTORE_VIEW;
/* 54:   */   }
/* 55:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.bean.seguridad.AuthenticationListener
 * JD-Core Version:    0.7.0.1
 */