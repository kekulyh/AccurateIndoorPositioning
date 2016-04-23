!function(Y,p,l){"use strict";var D="px",K="0",m="innerHTML",v="className",d=ht.Default,V=ht.Color,q=ht.Node,Z="position",R="top",o="left",i=d.animate,E=d.getInternal(),y="width",K="0",U="none",r="max-height",k="font",A="background",u="border-box",C="user-select",$="box-sizing",_="overflow",X=d.isTouchable,E=d.getInternal(),t=V.titleIconBackground,T=d.scrollBarInteractiveSize,P=/msie 9/.test(Y.navigator?Y.navigator.userAgent.toLowerCase():""),e=null,f=function(){return document},g=function(_){return f().createElement(_)},L=function(){return g("div")},s=function(){var E=L(),D=E.style;return D.msTouchAction=U,D.cursor="default",X&&D.setProperty("-webkit-tap-highlight-color","rgba(0, 0, 0, 0)",e),D.position="absolute",D.left=K,D.top=K,E},Q=function(){return g("canvas")},G=function(){return document.body},S=function(Y,o,z){Y.style.setProperty(o,z,e)},x=function(Y,L){Y.style.removeProperty(L)},M=function(y,F,c){d.def(ht.widget[y],F,c)},J=function(q,c){q.appendChild(c)},z=function(f,K){f.removeChild(K)},n=function($,E,i,c){$.addEventListener(E,i,!!c)};E.addMethod(d,{paletteExpandIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:t,rotation:3.14}]},paletteCollapseIcon:{width:16,height:16,comps:[{type:"triangle",rect:[4,4,10,8],background:t}]},paletteTitleLabelColor:d.labelSelectColor,paletteTitleLabelFont:d.labelFont,paletteContentLabelFont:d.labelFont,paletteContentLabelColor:"#777",paletteContentBackground:"#fff",paletteTitleHeight:d.widgetTitleHeight,paletteTitleBackground:V.titleBackground,paletteTitleHoverBackground:V.titleBackground,paletteSeparatorWidth:1,paletteSeparatorColor:l,paletteItemHoverBorderColor:V.highlight,paletteItemSelectBackground:V.highlight},!0);var B=".palette-item:hover{border: 1px solid "+d.paletteItemHoverBorderColor+" !important}"+" .palette-header:hover{background: "+d.paletteTitleHoverBackground+" !important}",I=document.createElement("style");X||(I.styleSheet?I.styleSheet.cssText=B:I.appendChild(f().createTextNode(B))),f().getElementsByTagName("head")[0].appendChild(I);var h=function(v){var V=this;V.$22h=v,V.addListeners()};d.def(h,p,{ms_listener:1,getView:function(){return this.$22h.getView()},$26h:function(){var k=this;k.$36h&&G().removeChild(k.$36h),k.$23h=k.$24h=k.$25h=k.$35h=k.$36h=e},handle_touchstart:function(a){for(var T,K=this,N=K.$22h,c=a.target,O=N.sm(),X=N.dm(),P="palette-header",o="palette-header-tool",t="palette-item",M=!1,G=!1,m=!1;c&&(c[v]||"").indexOf(P)<0&&(c[v]||"").indexOf(t)<0;)c=c.parentNode;if(c&&c[v].indexOf(o)>=0?M=!0:c&&c[v].indexOf(P)>=0?m=!0:c&&c[v].indexOf(t)>=0&&(G=!0),d.isLeftButton(a))if(K.$27h(a))K.$24h=d.getClientPoint(a),K.$25h=N.ty();else if(M){d.preventDefault(a),T=c.parentNode.$11h;var C=X.getDataById(T),y=C.s("tools")[c.toolIndex];y.action&&y.action.call(N)}else if(m){d.preventDefault(a),T=c.$11h;var C=X.getDataById(T);C.isExpanded()?C.setExpanded(!1):C.setExpanded(!0)}else if(G){T=c.$11h;var D=X.getDataById(T);O.ss(D),N.handleDragAndDrop&&(d.preventDefault(a),D.s("draggable")&&(N.handleDragAndDrop(a,"prepare"),K.$35h=0)),D.s("draggable")||(d.preventDefault(a),K.$24h=d.getClientPoint(a),K.$25h=N.ty())}else d.preventDefault(a),K.$24h=d.getClientPoint(a),K.$25h=N.ty();else K.$26h(a)},handle_mousedown:function(l){this.handle_touchstart(l)},handle_mousewheel:function(N){this.handleScroll(N,N.wheelDelta/40,N.wheelDelta!==N.wheelDeltaX)},handle_DOMMouseScroll:function(O){this.handleScroll(O,-O.detail,1)},handleScroll:function(n,U,q){var V=this.$22h;d.preventDefault(n),q&&V._41o()&&V.ty(V.ty()+20*U)},handle_mouseup:function(h){this.handle_touchend(h)},handle_touchend:function(q){var V=this;V.$37h(q),V.$26h(q)},handleWindowMouseUp:function(O){this.handleWindowTouchEnd(O)},handleWindowTouchEnd:function(z){var l=this;l.$37h(z),l.$26h(z)},$37h:function(P){var t=this,A=t.$22h;2===t.$35h&&(t.$35h=3,A.handleDragAndDrop(P,"end"))},handleWindowMouseMove:function(T){this.handleWindowTouchMove(T)},handleWindowTouchMove:function(t){var _=this,m=_.$22h,j=_.$23h,W=_.$24h,F=_.$25h,A=d.getClientPoint(t),M=m._29I,K=_.$36h;if(1===_.$35h||2===_.$35h){if(_.$35h=2,m.handleDragAndDrop(t,"between"),X){var e=t.touches[0];t=e?e:t.changedTouches[0]}K.style.left=t.pageX-parseInt(K.width)/2+D,K.style.top=t.pageY-parseInt(K.height)/2+D}else"p"===j?m.ty(F+A.y-W.y):"v"===j&&m.ty(F+(W.y-A.y)/M.height*m._59I)},handle_mousemove:function(p){this.handle_touchmove(p)},handle_touchmove:function(Z){if(!d.isDragging()&&d.isLeftButton(Z)){var h=this,p=h.$22h,B=h.$27h(Z);if(h.$24h){if(!h.$23h){if(d.getDistance(d.getClientPoint(Z),h.$24h)<2)return;h.$23h=B?"v":"p",d.startDragging(h)}}else if(B)p._43o();else if(0===h.$35h){if(h.$35h=1,p.handleDragAndDrop(Z,"begin"),X){var g=Z.touches[0];Z=g?g:Z.changedTouches[0]}var z=h.$36h=new Image,C=p.$10h[p.sm().ld().getId()].querySelector(".image-box"),J=parseInt(C.style.width),q=parseInt(C.style.height);z.draggable=!1,z.src=C.toDataURL(),z.width=J,z.height=q,z.style.position="absolute",z.style.left=Z.pageX-J/2+D,z.style.top=Z.pageY-q/2+D,G().appendChild(z),d.startDragging(h)}}},$27h:function(c){var P=this.$22h,B=P.getView(),j=B.getBoundingClientRect(),O=P._29I,M=c.clientX-j.left+B.scrollLeft;return P._41o()&&O.x+O.width-M<T}}),ht.widget.Palette=function(M){var N=this,t=N._view=L();N.$9h={},N.$10h={},N.$4h={},N._29I={x:0,y:0,width:0,height:0},N._59I=0,N.dm(M?M:new ht.DataModel),t[v]="ht-widget-palette",N.$29h=new h(N),S(t,A,d.paletteContentBackground),S(t,_,"auto"),S(t,$,u),S(t,"-moz-"+$,u),S(t,"-webkit-"+C,U),S(t,"-moz-"+C,U),S(t,"-ms-"+C,U),S(t,C,U),S(t,"position","absolute"),S(t,"overflow","hidden"),J(t,N._79O=s()),n(t,"dragstart",function(t){t.dataTransfer&&(t.dataTransfer.setData("Text","nodeid:"+t.target.$11h),t.dataTransfer.effectAllowed="all",N.$29h.$26h())})},M("Palette",p,{ms_v:1,ms_fire:1,ms_dm:1,ms_sm:1,ms_vs:1,ms_ac:["itemImageWidth","itemImageHeight","itemImagePadding","itemMargin","layout","autoHideScrollBar","scrollBarSize","scrollBarColor"],$30h:0,_itemImagePadding:4,_itemImageWidth:70,_itemImageHeight:50,_itemMargin:10,_layout:"largeicons",_autoHideScrollBar:d.autoHideScrollBar,_scrollBarSize:d.scrollBarSize,_scrollBarColor:d.scrollBarColor,getViewRect:function(){return this._29I},ty:function(W){return W?(this.setTranslateY(W),void 0):this.getTranslateY()},setTranslateY:function(X){if(this.$32h==e){var J=this,R=J.$33h(X),o=J.$30h;J.$30h=R,J.fp("translateY",o,R)}},getTranslateY:function(){return this.$30h},setLayout:function(b){var T,u,X=this,d=X._layout;X._layout=b,"smallicons"===b?T=u=20:"iconsonly"===b?T=u=50:(T=70,u=50),X.setItemImageWidth(T),X.setItemImageHeight(u),X.setItemImagePadding(4),X.fp("layout",d,b)},getDataAt:function(Q){for(var y=Q.target;y&&y.$11h==e;)y=y.parentNode;return y&&y.$11h!=e?this.getDataModel().getDataById(y.$11h):void 0},$20h:function(){var W=16;return X&&(W*=1.2),W},$19h:function(){return d.paletteTitleHeight},$18h:function(){var u=d.paletteSeparatorWidth,f=d.paletteTitleBackground,G=d.paletteSeparatorColor||d.brighter(f);return u+D+" solid "+G},$17h:function(Z){S(Z,"cursor","pointer"),S(Z,"display","inline-block"),S(Z,"margin-right",(X?8:4)+D),S(Z,"vertical-align",R)},$1h:function(M){var B=this,T=L(),a=L(),i=g("span");T[v]="palette-header",S(T,Z,"relative"),S(T,A,d.paletteTitleBackground),S(T,"color",d.paletteTitleLabelColor),S(T,R,K),S(T,$,u),S(T,"-moz-"+$,u),S(T,"padding","0 5px 0 0"),S(T,"border-top",B.$18h()),S(T,y,"100%"),S(T,"cursor","pointer"),S(T,"white-space","nowrap"),S(T,_,"hidden"),S(T,k,d.paletteTitleLabelFont),S(T,"line-height",B.$19h()+D),T.$11h=M.getId();var G=Q(),W=B.$19h(),p=B.$20h();B.$17h(G),E.setCanvas(G,p,W),J(T,G);var n=M.s("tools");if(n)for(var X=0;X<n.length;X++){var I=Q();B.$17h(I),E.setCanvas(I,p,W),I[v]="palette-header-tool palette-header-tool"+M.getId()+"-"+X,I.style.position="absolute",I.style.right=(p+10)*X+"px",I.toolIndex=X,J(T,I)}return G[v]="palette-toggle-icon-"+M.getId(),a[v]="palette-content",S(a,"max-height",0+D),S(a,k,d.paletteContentLabelFont),S(a,_,"hidden"),a.$11h=M.getId(),B.$9h[M.getId()]=a,i[m]=M.getName(),S(i,k,d.paletteTitleLabelFont),J(T,G),J(T,i),[T,a]},$2h:function(t){var T=this,H=T._layout,B=P&&t.s("draggable")?g("a"):L(),n=Q(),e=L(),N=t.getName()||"",Z=t.s("title")||t.getToolTip()||N,l=T._itemMargin;n[v]="image-box";var G=T.getItemImageWidth(),X=T.getItemImageHeight();return E.setCanvas(n,G,X),J(B,n),e[m]=N,e[v]="label-box","iconsonly"!==H&&J(B,e),B[v]="palette-item",S(B,"vertical-align",R),S(B,"cursor","pointer"),S(B,"border-radius",5+D),S(B,"border","1px solid transparent"),S(B,"text-align","center"),S(B,"display","inline-block"),S(B,"margin-left",l+D),S(B,"margin-top",l+D),S(B,"color",d.paletteContentLabelColor),"smallicons"===H?(S(n,"vertical-align","middle"),S(B,"margin-left",2+D),S(B,"margin-top",2+D),S(B,"padding",2+D),S(B,"text-align",o),S(e,"display","inline-block"),S(e,"min-width",T.$21h+T._itemMargin+D)):"largeicons"===H&&(S(e,"max-width",G+D),S(e,"overflow","hidden")),B.$11h=t.getId(),Z&&(B.title=Z),t.s("draggable")&&!T.handleDragAndDrop&&(P?(B.href="#",S(B,"text-decoration",U)):B.draggable="true"),B},$16h:function(w,t,I,$){var J=E.initContext(w);E.translateAndScale(J,0,0,1),J.clearRect(0,0,I,I);var D=(I-$)/2;d.drawStretchImage(J,d.getImage(t),"fill",0,D,$,$),J.restore()},$15h:function(S){var w=this,u=S.getId(),O=w._view.querySelector(".palette-toggle-icon-"+u),V=S.isExpanded()?d.paletteCollapseIcon:d.paletteExpandIcon;if(O&&V){var o=w.$19h(),m=w.$20h();w.$16h(O,V,o,m)}},_drawToolsIcon:function(W){var b=this,q=W.s("tools");if(q)for(var z=0;z<q.length;z++){var p=b._view.querySelector(".palette-header-tool"+W.getId()+"-"+z),Q=q[z].icon,B=b.$19h(),t=b.$20h();b.$16h(p,Q,B,t)}},$14h:function(y){var $=this,Y=y.getId(),s=$.$10h[Y].querySelector(".image-box"),o=y.getImage(),Z=y.s("image.stretch");if(s&&o){var r=E.initContext(s),k=$.getItemImagePadding();k="smallicons"===$._layout?k/2:k;var D=$.getItemImageWidth()-2*k,W=$.getItemImageHeight()-2*k;E.translateAndScale(r,0,0,1),r.clearRect(0,0,D,W),d.drawStretchImage(r,d.getImage(o),Z,k,k,D,W),r.restore()}},validateImpl:function(){var a,Z,C,S=this,$=S.$9h,N=S._layout,R=S.$10h,l=S.$4h,U=S._view,H=S.dm();if(S.$13h&&(delete S.$13h,l={},H.each(function(o){l[o.getId()]=o})),"smallicons"===N)for(var O in l){var Y=l[O];if(Y instanceof q){var j=Y.getName()||"",k=d.getTextSize(d.paletteContentLabelFont,j).width;S.$21h!=e&&S.$21h>k||(S.$21h=k)}}for(var O in l){C=l[O];var F,W;if(H.contains(C)){if(C instanceof ht.Group){var p,s=S.$1h(C),t=R[C.getId()];t&&(p=t.nextSibling,z(U,p),z(U,t)),Z=H.getSiblings(C).indexOf(C);var n=U.children[2*Z]||S._79O;U.insertBefore(s[0],n),U.insertBefore(p||s[1],n),R[C.getId()]=s[0],a=$[C.getId()]=p||s[1],W=C.$12h;var u=C.s("promptText");W||(C.$12h=g("div"),C.$12h[m]=u||"",W=C.$12h),0===C.getChildren().size()?a.contains(W)||J(a,W):a.contains(W)&&z(a,W)}else if(F=C.getParent()){var x=S.$2h(C),y=R[C.getId()];a=$[F.getId()],y&&z(y.parentNode,y),Z=H.getSiblings(C).indexOf(C);var c=a.children[Z];c?a.insertBefore(x,c):J(a,x),R[C.getId()]=x,S.$14h(C)}}else{var T=R[C.getId()],M=T.parentNode;if(C instanceof ht.Group){var V=T.nextSibling;z(U,T),z(U,V),delete $[C.getId()]}else z(M,T),0===M.children.length&&(F=H.getDataById(M.$11h),W=F.$12h,W&&!M.contains(W)&&J(M,W));delete R[C.getId()]}}S.$4h={};var Q=function(){var T=S._59I,i=0;S.$32h!=e&&(clearInterval(S.$32h),i=0,delete S.$32h),S.$32h=setInterval(function(){S.$31h(),T===S._59I?(i++,i>=2&&(clearInterval(S.$32h),delete S.$32h)):(i=0,T=S._59I)},30)};for(var w in $)if(a=$[w],C=H.getDataById($[w].$11h),S.$15h(C),S._drawToolsIcon(C),C.isExpanded()){if(a.style.maxHeight===0+D){var B=a.scrollHeight+S._itemMargin+D;i(a).duration(200).set(r,B).set("padding-bottom",S._itemMargin+D).end(function(){return function(){Q()}}(B))}else a.style.maxHeight=a.scrollHeight+D;a.style.paddingBottom=S._itemMargin+D}else a.style.maxHeight!==0+D&&i(a).duration(200).set(r,K).set("padding-bottom",K).end(function(){return function(){Q()}}(a));S.$28h(),S.$31h()},$31h:function(){for(var Z=this,e=Z._view,K=0,H=e.children,N=0;N<H.length;N++){var s=H[N];s.className&&s.className.indexOf("palette-")>=0&&(K+=s.offsetHeight)}Z._59I=K,Z.$30h=Z.$33h(Z.ty());var M=Z.ty();e.scrollTop=-M,Z._29I={x:0,y:-M,width:e.clientWidth,height:e.clientHeight},S(Z._79O,R,-M+D),Z._93I()},$33h:function(O){var F=this,E=F._29I.height-F._59I;return E>O&&(O=E),O>0?0:Math.round(O)},redraw:function(){this.$13h||(this.$13h=1,this.iv())},onPropertyChanged:function(f){["autoHideScrollBar","scrollBarSize","scrollBarColor","translateY"].indexOf(f.property)<0&&this.redraw(),"translateY"===f.property&&(this.iv(),this._43o())},findDataByName:function(z){for(var c=this.dm().getDatas(),B=0;B<c.size();B++){var d=c.get(B);if(d.getName()===z)return d}},setDataModel:function(j){var i=this,b=i._dataModel,n=i._3o;b!==j&&(b&&(b.umm(i.$6h,i),b.umd(i.$8h,i),b.umh(i.$7h,i),n||b.sm().ums(i.$28h,i)),i._dataModel=j,j.mm(i.$6h,i),j.md(i.$8h,i),j.mh(i.$7h,i),n?n._21I(j):j.sm().ms(i.$28h,i),i.sm().setSelectionMode("single"),i.fp("dataModel",b,j))},$6h:function(C){var j=this,z=j._view,E=C.data,b=j.$4h;"add"===C.kind?b[E.getId()]=E:"remove"===C.kind?b[E.getId()]=E:"clear"===C.kind&&(j.$10h={},j.$9h={},j.$4h={},z[m]=""),j.iv()},$7h:function(g){var b=this,G=g.data;b.$4h[G.getId()]=G,b.iv()},$8h:function(E){var l=this,Y=E.data,F=E.property;"expanded"===F?l.iv():(l.$4h[Y.getId()]=Y,l.iv())},$28h:function(){var b,z=this,g=z.sm(),F="palette-item",J=g.ld();this.dm().each(function(G){b=z.$10h[G.getId()],b&&b[v].indexOf(F)>=0&&(G===J?S(b,A,d.paletteItemSelectBackground):x(b,A))})}})}(this,Object);