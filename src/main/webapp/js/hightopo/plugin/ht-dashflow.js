!function(E){"use strict";var z="ht",D=E[z],V=D.Default,N=Math,X=(N.PI,N.sin,N.cos,N.atan2,N.sqrt,N.max),F=N.floor,O=(N.round,N.ceil),Z=D.Shape,g=(D.Edge,D.List),S=D.Style,T=D.graph,M=V.getInternal(),t=M.ui(),y=null,R="prototype",o=E.clearInterval,P=E.setInterval,f=function(m){var I=m.data,$=this.dm();if(I&&"add"===m.kind){var K=$.$1c,h=I instanceof Z?"shape.":"edge.";K&&I.s(h+"dash.flow")&&K.indexOf(I)<0&&K.push(I)}"clear"===m.kind&&($.$1c=[])},j=function(X){var k=X.property,Q=X.data,B=X.newValue,d=this.dm().$1c,H=Q instanceof Z?"s:shape.dash.flow":"s:edge.dash.flow";if(d&&k===H)if(B)d.indexOf(Q)<0&&d.push(Q);else for(var J=d.length,t=0;J>t;t++)if(d[t]===Q){d.splice(t,1);break}},J=T.GraphView[R],c=t.EdgeUI[R],e=t.ShapeUI[R],a=e._80o,k=c._80o,Q=D.DataModel[R],v=Q.prepareRemove,W=J.setDataModel;S["edge.dash.flow.step"]==y&&(S["edge.dash.flow.step"]=3),S["shape.dash.flow.step"]==y&&(S["shape.dash.flow.step"]=3),Q.prepareRemove=function(_){v.call(this,_);var s=_._dataModel,G=s.$1c;if(G)for(var e=G.length,f=0;e>f;f++)if(G[f]===_){G.splice(f,1);break}},J.setDataModel=function(i){var V=this,g=V._dataModel;if(g!==i){g&&(g.umm(f,V),g.umd(j,V),g.$1c=[]),i.mm(f,V),i.md(j,V);var $=i.$1c=[];i.each(function(R){var C=R instanceof Z?"shape.":"edge.";R.s(C+"dash.flow")&&$.indexOf(R)<0&&$.push(R)}),W.call(V,i)}},J.setDashFlowInterval=function(s){var D=this,b=D.$2c;D.$2c=s,D.fp("dashFlowInterval",b,s),D.$3c!=y&&(o(D.$3c),delete D.$3c,D.enableDashFlow(s))},J.getDashFlowInterval=function(){return this.$2c},J.$4c=function(){var E,y,U,L=this,t=L.tx(),W=L.ty(),n=L._zoom,z=L.getWidth(),N=L.getHeight(),b={x:-t/n,y:-W/n,width:z/n,height:N/n},s=L.dm().$1c,P=L._56I,S=new g;if(s.forEach(function(z){P[z.getId()]&&(E=L.getDataUI(z),E&&(U=E._79o(),U&&S.add(U)))}),0!==S.size()&&(S.each(function(A){V.intersectsRect(b,A)&&(y=V.unionRect(y,A))}),y&&(y&&(V.grow(y,X(1,1/n)),y.x=F(y.x*n)/n,y.y=F(y.y*n)/n,y.width=O(y.width*n)/n,y.height=O(y.height*n)/n,y=V.intersection(b,y)),y))){var m=L._canvas.getContext("2d");m.save(),m.lineCap=V.lineCap,m.lineJoin=V.lineJoin,M.translateAndScale(m,t,W,n),m.beginPath(),m.rect(y.x,y.y,y.width,y.height),m.clip(),m.clearRect(y.x,y.y,y.width,y.height),L.$5c(m,y),m.restore()}},J.$5c=function(w,K){var C,i,Q=this;Q._93db(w),Q.each(function(n){Q._56I[n._id]&&(C=Q.getDataUI(n),C&&(i=C._79o(),(!K||V.intersectsRect(K,i))&&(C.$7c=!0,C._42(w),delete C.$7c)))}),Q._92db(w)},J.enableDashFlow=function(X){var O=this;O.$3c==y&&(O.$3c=P(function(){O.$4c()},X||O.$2c||50))},J.disableDashFlow=function(){var f=this;o(f.$3c),delete f.$3c};var $=function(){var N=this,M=N._data,m=M instanceof Z?"shape.":"edge.",p=M.s(m+"dash.pattern"),R=M.s(m+"dash.flow.reverse");if(p&&M.s(m+"dash")&&M.s(m+"dash.flow")&&N.$7c){var H=N.s(m+"dash.offset")||0,c=M.s(m+"dash.flow.step"),Y=M.getStyleMap(),V=0;p.forEach(function(p){V+=p}),R&&(c=-c),H-=c,H%=V,Y||(M._styleMap=Y={}),Y[m+"dash.offset"]=H}};c._80o=function(F){k.call(this,F),$.call(this)},e._80o=function(_){a.call(this,_),$.call(this)}}(this,Object);