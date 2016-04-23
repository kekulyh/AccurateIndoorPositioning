!function(M,G){"use strict";var o="ht",f=M[o],p="innerHTML",Z="className",W=null,c="px",u=f.Default,A=u.getInternal(),d="0",I=function(){return document},n=function(A){return I().createElement(A)},x=function(){return n("div")},h=function(){return n("canvas")},D=function(b,f,F){b.style.setProperty(f,F,W)},i=function(M,K,R){u.def(f.widget[M],K,R)},b=function(p,o){p.appendChild(o)},r=function(X,j){X.removeChild(j)},B=function(p,z,L,o){p.addEventListener(z,L,!!o)},w=function(Q,$,l,m){Q.removeEventListener($,l,!!m)},$=u.isTouchable;A.addMethod(u,{menuLabelFont:($?"16":"13")+"px arial, sans-serif",menuLabelColor:"#000",menuBackground:"#F0EFEE",menuHoverBackground:"#648BFE",menuHoverLabelColor:"#fff",menuSeparatorWidth:1,menuSeparatorColor:"#999"},!0),f.widget.Menu=function(N){var g=this,_=g._view=x(),T=g.$1g=new f.widget.ContextMenu,k=n("ul");T._r=!0,T._view[Z]+=" ht-widget-dropdownmenu",_[Z]="ht-widget-menu",k[Z]="header",D(_,"margin",d),D(_,"padding",d),D(_,"background",u.menuBackground),D(_,"-webkit-user-select","none"),D(_,"-moz-user-select","none"),D(_,"user-select","none"),D(_,"text-align","left"),D(_,"border-bottom",u.menuSeparatorWidth+"px solid "+u.menuSeparatorColor),D(_,"cursor","default"),D(_,"overflow","auto"),D(_,"white-space","nowrap"),D(_,"font",u.menuLabelFont),D(_,"color",u.menuLabelColor),D(_,"box-sizing","border-box"),D(_,"-moz-box-sizing","border-box"),D(k,"list-style","none"),D(k,"margin",d),D(k,"padding",d),D(k,"display","inline-block"),b(_,k),g.setItems(N),g.$2g=function(K){g.$3g(K)},g.$4g=function(U){g.$5g(U)},g.$6g=function(W){g.$7g(W)},g.$8g=function(s){g.$9g(s)},g.$9b=function(e){g.$10g(e)},g._autoShow=!0,g.setAutoShow(!1),T.afterHide=function(){g.$11g()},T.afterShow=function(){g.$12g()},w(I(),"keydown",T.$3b),g.$3b=function(K){g.$13g(K)},g.invalidate()},i("Menu",G,{_items:W,$14g:u.menuHoverBackground,$15g:u.menuHoverLabelColor,$16g:{},_enableGlobalKey:!1,ms_v:1,$21g:"smallicons",$22g:0,$23g:0,$24g:"left",getDropDownMenu:function(){return this.$1g},setLayout:function(n){var u=this;if(u.$21g=n,u.setItems(u._items),"largeicons"===n){for(var Q=u._view.querySelectorAll(".header-item"),B=0,K=0;K<Q.length;K++){var j=Q[K];B=Math.max(B,j.clientWidth)}for(var K=0;K<Q.length;K++){var j=Q[K];D(j,"min-width",B+c)}}this.invalidate()},getLayout:function(){return this.$21g},setHeaderItemHGap:function(J){this.$22g=J;for(var s=this._view.querySelectorAll(".header-item"),A=0;A<s.length;A++){var d=s[A];D(d,"margin-left",J+c),D(d,"margin-right",J+c)}},getHeaderItemHGap:function(){return this.$22g},setHeaderItemVGap:function(g){this.$23g=g;for(var X=this._view.querySelectorAll(".header-item"),l=0;l<X.length;l++){var $=X[l];D($,"margin-top",g+c),D($,"margin-bottom",g+c)}},getHeaderItemVGap:function(){return this.$24g},setHeaderItemAlign:function(L){this.$24g=L,D(this._view,"text-align",L)},getHeaderItemAlign:function(){return this.$23g},enableGlobalKey:function(){var q=this,d=q._enableGlobalKey;d===!1&&(B(I(),"keydown",q.$3b),q._enableGlobalKey=!0)},disableGlobalKey:function(){this._enableGlobalKey=!1,w(I(),"keydown",this.$3b)},setHoverBackground:function(Y){this.$14g=Y},setHoverColor:function(z){this.$15g=z},setItems:function(f){var t=this,U=t._view,B=t.$21g;if(t._items=f,U.children[0][p]="",t.$16g={},f&&f.length){for(var m=U.children[0],F=0,k=I().createDocumentFragment();F<f.length;F++){var Q=f[F],V=n("li"),Y=n("span");if(Q.icon){var g=h();g[Z]="menu-item-icon","smallicons"===B?(D(g,"height","1.2em"),D(g,"width","1.2em"),D(g,"vertical-align","middle")):(D(g,"height","32px"),D(g,"width","32px"),D(g,"display","block"),D(g,"margin","0 auto")),g.$20g=Q.icon,b(V,g)}V[Z]="header-item",D(V,"display","inline-block"),D(V,"vertical-align","top"),D(V,"padding","0 1.2em"),D(V,"line-height","1.8em"),"largeicons"===B&&D(V,"text-align","center"),D(V,"background-color","rgba(0,0,0,0)"),V.setAttribute("data-index",F),t.$16g[F]=Q.items,Y[p]=Q.label,"iconsonly"!==B&&b(V,Y),b(k,V)}b(m,k)}},showDropdownMenu:function(e){var O=this,t=O.$16g[e],s=O.$1g,B=O._view.children[0].children[e],H=O.$17g;if(B&&B!==H){H&&O.hideDropdownMenu();var U=B.getBoundingClientRect(),Q=u.getWindowInfo();O.$17g=B,s.setItems(t),s.show(U.left+Q.left,U.top+U.height+Q.top,!1)}},hideDropdownMenu:function(){this.$1g.hide()},getItemByProperty:function(s,U){var h=this,b=h._items;return b&&0!==b.length?h.$1g.getItemByProperty(s,U,b):W},$12g:function(){var f=this,q=f.$17g;q.style.background=f.$14g,q.style.color=f.$15g,f._autoShow||B(I(),$?"touchstart":"mousedown",f.$9b)},$11g:function(){var Y=this,t=Y.$17g;t&&(t.style.background="",t.style.color="",Y.$17g=W),w(I(),$?"touchstart":"mousedown",Y.$9b)},$10g:function(R){var J=this,l=J._view,y=J.$1g,W=l.children[0];!I().body.contains(l)||W.contains(R.target)||y._view.contains(R.target)||J.hideDropdownMenu()},$13g:function(o){var M=this,D=M.$1g;I().body.contains(M._view)&&D.$13b.$4b.call(D.$13b,o,M._items)},setAutoShow:function(X){var C=this,D=C.$1g,L=C._view;C._autoShow!==X&&(C._autoShow?(w(L,"mouseover",C.$2g),w(L,"mouseout",C.$4g),w(D._view,"mouseout",C.$4g),$||(B(L,"mouseover",C.$8g),B(L,"mouseout",C.$8g)),B(L,$?"touchstart":"mousedown",C.$6g)):(w(L,"mouseover",C.$8g),w(L,"mouseout",C.$8g),w(L,$?"touchstart":"mousedown",C.$6g),w(I(),$?"touchstart":"mousedown",C.$9b),$||(B(L,"mouseover",C.$2g),B(L,"mouseout",C.$4g),B(D._view,"mouseout",C.$4g))),C._autoShow=X)},$3g:function(X){var F=this,d=F._view.children[0],Y=X.target;if(d!==Y&&d.contains(Y)){for(;"header-item"!==Y[Z];)Y=Y.parentNode;F.showDropdownMenu(Y.getAttribute("data-index"))}},$5g:function(c){var u=this,P=u._view.children[0],X=u.$1g,s=c.target,j=c.relatedTarget;!P.contains(s)&&!X._view.contains(s)||P.contains(j)||X._view.contains(j)||u.hideDropdownMenu()},$7g:function(b){var i=this,a=i._view.children[0],p=i.$1g,S=b.target;if(u.isLeftButton(b)&&a!==S&&a.contains(S))if($){for(;"header-item"!==S[Z];)S=S.parentNode;var w=S.getAttribute("data-index"),p=i.$1g,V=i._view.children[0].children[w],x=i.$17g;p.isShowing()&&i.hideDropdownMenu(),V!==x&&i.showDropdownMenu(w)}else if(p.isShowing())i.hideDropdownMenu();else{for(;"header-item"!==S[Z];)S=S.parentNode;i.showDropdownMenu(S.getAttribute("data-index"))}},$9g:function(c){var C=this,F=C._view,o=C.$1g,y=c.target;if(F.contains(y)){for(var r=F.querySelectorAll(".header-item"),U=W,T=0;T<r.length;T++){var H=r[T];H.style.background="",H.style.color="","mouseover"===c.type?H.contains(y)&&(U=H):"mouseout"===c.type&&o.isShowing()&&C.$17g===H&&(U=H)}o.isShowing()&&(U||(U=C.$17g),C.showDropdownMenu(U.getAttribute("data-index"))),U&&(U.style.background=C.$14g,U.style.color=C.$15g)}},getShowingMenuIndex:function(){var Q=this.$17g;return Q?Q.getAttribute("data-index"):-1},addTo:function(r){var l=this,i=l._view;b(r,i),l.invalidate()},dispose:function(){var J=this,M=J._view,A=J.$1g;M&&(J._autoShow?(w(M,"mouseover",J.$2g),w(M,"mouseout",J.$4g),w(A._view,"mouseout",J.$4g)):(w(M,"mouseover",J.$8g),w(M,"mouseout",J.$8g),w(M,$?"touchstart":"mousedown",J.$6g),w(I(),$?"touchstart":"mousedown",J.$9b)),w(I(),"keydown",J.$3b),A.dispose(),M.parentNode&&r(M.parentNode,M),J._view=J.$1g=J.$16g=J._items=J.$17g=J.$2g=J.$4g=J.$6g=J.$8g=J.$9b=J.$3b=W)},$19g:function($,M,q,U){var I=A.initContext($);A.translateAndScale(I,0,0,1),I.clearRect(0,0,q,U),u.drawStretchImage(I,u.getImage(M),"fill",0,0,q,U),I.restore()},validateImpl:function(){var h,X,D,G=this,S=G._view,d=S.querySelectorAll(".menu-item-icon");for(D=0;D<d.length;D++){var g=d[D];h=g.clientWidth,X=g.clientHeight,h&&X&&(A.setCanvas(g,h,X),G.$19g(g,u.getImage(g.$20g),h,X))}}})}(this,Object);