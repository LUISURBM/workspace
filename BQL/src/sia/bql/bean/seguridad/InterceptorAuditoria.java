/*  1:   */ package sia.bql.bean.seguridad;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import javax.faces.application.Application;
/*  5:   */ import javax.faces.context.FacesContext;
/*  6:   */ import javax.faces.el.ValueBinding;
/*  7:   */ import org.apache.commons.lang.ArrayUtils;
/*  8:   */ import org.hibernate.EmptyInterceptor;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.type.Type;
/* 11:   */ import sia.bql.hibernate.HibernateSessionFactory;
/* 12:   */ import sia.bql.hibernate.sioperan.IdtUsers;
/* 13:   */ 
/* 14:   */ public class InterceptorAuditoria
/* 15:   */   extends EmptyInterceptor
/* 16:   */ {
/* 17:   */   private static final long serialVersionUID = 1L;
/* 18:   */   
/* 19:   */   private boolean colocarUsuario(Object[] state, String[] propertyNames)
/* 20:   */   {
/* 21:41 */     int i = ArrayUtils.indexOf(propertyNames, "idtUsers");
/* 22:42 */     if (i == -1) {
/* 23:43 */       return false;
/* 24:   */     }
/* 25:44 */     AuthenticationBean au = (AuthenticationBean)context().getApplication().createValueBinding("#{Authentication}").getValue(context());
/* 26:45 */     if (au.getUserId() == null) {
/* 27:46 */       return false;
/* 28:   */     }
/* 29:47 */     if ((state[i] != null) && (((IdtUsers)state[i]).getUsrId().equals(au.getUserId()))) {
/* 30:48 */       return false;
/* 31:   */     }
/* 32:49 */     IdtUsers usuario = (IdtUsers)HibernateSessionFactory.getSession().load(IdtUsers.class, au.getUserId());
/* 33:50 */     state[i] = usuario;
/* 34:51 */     return true;
/* 35:   */   }
/* 36:   */   
/* 37:   */   private FacesContext context()
/* 38:   */   {
/* 39:59 */     return FacesContext.getCurrentInstance();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types)
/* 43:   */   {
/* 44:68 */     return colocarUsuario(currentState, propertyNames);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
/* 48:   */   {
/* 49:77 */     return colocarUsuario(state, propertyNames);
/* 50:   */   }
/* 51:   */ }


/* Location:           C:\Users\Luis\Desktop\CLXX\BalanceQL\Fuentes\
 * Qualified Name:     sia.bql.bean.seguridad.InterceptorAuditoria
 * JD-Core Version:    0.7.0.1
 */