!function(U,H){"use strict";var R="ht",t=U[R],v=function(p){return(/ble$/.test(p)||/ed$/.test(p)||t.IsGetter[p]?"is":"get")+p.charAt(0).toUpperCase()+p.slice(1)};t.QuickFinder=function(U,m,Y,R,d){var f=this;f.$9j={},f.$1j=U,f.$2j=m,f.$3j=Y,f.$4j=R||f.getValue,f.$5j=d||f.$5j,U.each(f.$7j,f),U.mm(f.$11j,f,!0),U.md(f.$12j,f,!0)},t.Default.def(t.QuickFinder,H,{$6j:"__ht__null__",getValueFunc:function(){return this.$4j},getFilterFunc:function(){return this.$5j},$11j:function(R){"add"===R.kind?this.$7j(R.data):"remove"===R.kind?this.$8j(R.data):"clear"===R.kind&&(this.$9j={})},$12j:function(H){var $=this,X=$.$3j,A=$.$2j;if($.$5j(H.data)){if(null==X&&A===H.property);else if("style"===X&&"s:"+A===H.property);else if("attr"!==X||"a:"+A!==H.property)return;var t=$.$10j(H.oldValue);t&&t.remove(H.data),$.$7j(H.data)}},$10j:function(c){return c=null==c?this.$6j:c,this.$9j[c]},find:function(K){var M=this.$10j(K);return M?M.toList():new t.List},findFirst:function(S){var v=this.$10j(S);return!v||v.isEmpty()?null:v.get(0)},$7j:function(x){var M=this;if(M.$5j(x)){var k=M.$4j(x),f=M.$10j(k);f||(f=new t.List,k=null==k?M.$6j:k,M.$9j[k]=f),f.add(x)}},$8j:function(O){var t=this;if(t.$5j(O)){var e=t.$4j(O),x=t.$10j(e);x&&(x.remove(O),x.isEmpty()&&(e=null==e?t.$6j:e,delete t.$9j[e]))}},dispose:function(){this.$1j.umm(this.$11j,this),this.$1j.umd(this.$12j,this),delete this.$1j},getDataModel:function(){return this.$1j},getAccessType:function(){return this.$3j},getPropertyName:function(){return this.$2j},$5j:function(l){return null!=this.$3j||this.$4j!==this.getValue||l[v(this.$2j)]?!0:!1},getValue:function(m){var F=this,i=F.$3j,S=F.$2j;return null==i?m[v(S)]():"style"===i?m.s(S):"attr"===i?m.a(S):void 0}})}(this,Object);