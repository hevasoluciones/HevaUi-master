function com_heva_ui_Main(){var O='',vb='" for "gwt:onLoadErrorFn"',tb='" for "gwt:onPropertyErrorFn"',hb='"><\/script>',Y='#',Gc='.cache.html',$='/',lc='509A7D7EA1102C9440E6AEF1A046F073',oc='66455C3EDD42CBF68FB078F357AE4B94',Bc='9032B1AB537F7AE9CB7C8E79F4CB44F6',Fc=':',mc=':1',pc=':10',qc=':11',rc=':12',sc=':13',tc=':14',nc=':2',uc=':3',vc=':4',wc=':5',xc=':6',yc=':7',zc=':8',Ac=':9',nb='::',Ic='<script defer="defer">com_heva_ui_Main.onInjectionDone(\'com.heva.ui.Main\')<\/script>',gb='<script id="',qb='=',Z='?',Cc='A37D90D24E752186F68F7B04C617E649',$b='ActiveXObject',sb='Bad handler "',Dc='C240C2E671059AAAA635DA3BDB5B1285',_b='ChromeTab.ChromeFrame',Hc='DOMContentLoaded',Ec='FA8DE78E509498B344EA46CD6F42D1EB',ib='SCRIPT',fb='__gwt_marker_com.heva.ui.Main',Vb='adobeair',Wb='air',jb='base',bb='baseUrl',S='begin',R='bootstrap',Bb='chrome',Zb='chromeframe',ab='clear.cache.gif',P='com.heva.ui.Main',db='com.heva.ui.Main.nocache.js',mb='com.heva.ui.Main::',pb='content',X='end',Rb='gecko',Tb='gecko1_8',Ub='gecko1_9',T='gwt.codesvr=',U='gwt.hosted=',V='gwt.hybrid',ub='gwt:onLoadErrorFn',rb='gwt:onPropertyErrorFn',ob='gwt:property',Ab='gxt.user.agent',jc='hosted.html?com_heva_ui_Main',Fb='ie6',Hb='ie7',Jb='ie8',Kb='ie9',wb='iframe',_='img',xb="javascript:''",fc='linux',ic='loadExternalRefs',ec='mac',dc='mac os x',cc='macintosh',kb='meta',zb='moduleRequested',W='moduleStartup',Db='msie',Eb='msie 6',Gb='msie 7',Ib='msie 8',lb='name',Cb='opera',yb='position:absolute;width:0;height:0;border:none',Sb='rv:1.8',Lb='safari',Nb='safari3',Pb='safari4',Qb='safari5',cb='script',kc='selectingPermutation',Q='startup',eb='undefined',ac='unknown',Xb='user.agent',bc='user.agent.os',Mb='version/3',Ob='version/4',Yb='webkit',hc='win32',gc='windows';var l=window,m=document,n=l.__gwtStatsEvent?function(a){return l.__gwtStatsEvent(a)}:null,o=l.__gwtStatsSessionId?l.__gwtStatsSessionId:null,p,q,r,s=O,t={},u=[],v=[],w=[],x=0,y,z;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:S});if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={}}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={}}function A(){var b=false;try{var c=l.location.search;return (c.indexOf(T)!=-1||(c.indexOf(U)!=-1||l.external&&l.external.gwtOnLoad))&&c.indexOf(V)==-1}catch(a){}A=function(){return b};return b}
function B(){if(p&&q){var b=m.getElementById(P);var c=b.contentWindow;if(A()){c.__gwt_getProperty=function(a){return G(a)}}com_heva_ui_Main=null;c.gwtOnLoad(y,P,s,x);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:X})}}
function C(){function e(a){var b=a.lastIndexOf(Y);if(b==-1){b=a.length}var c=a.indexOf(Z);if(c==-1){c=a.length}var d=a.lastIndexOf($,Math.min(c,b));return d>=0?a.substring(0,d+1):O}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=m.createElement(_);b.src=a+ab;a=e(b.src)}return a}
function g(){var a=E(bb);if(a!=null){return a}return O}
function h(){var a=m.getElementsByTagName(cb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(db)!=-1){return e(a[b].src)}}return O}
function i(){var a;if(typeof isBodyLoaded==eb||!isBodyLoaded()){var b=fb;var c;m.write(gb+b+hb);c=m.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=ib){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return O}
function j(){var a=m.getElementsByTagName(jb);if(a.length>0){return a[a.length-1].href}return O}
var k=g();if(k==O){k=h()}if(k==O){k=i()}if(k==O){k=j()}if(k==O){k=e(m.location.href)}k=f(k);s=k;return k}
function D(){var b=document.getElementsByTagName(kb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(lb),g;if(f){f=f.replace(mb,O);if(f.indexOf(nb)>=0){continue}if(f==ob){g=e.getAttribute(pb);if(g){var h,i=g.indexOf(qb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=O}t[f]=h}}else if(f==rb){g=e.getAttribute(pb);if(g){try{z=eval(g)}catch(a){alert(sb+g+tb)}}}else if(f==ub){g=e.getAttribute(pb);if(g){try{y=eval(g)}catch(a){alert(sb+g+vb)}}}}}}
function E(a){var b=t[a];return b==null?null:b}
function F(a,b){var c=w;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function G(a){var b=v[a](),c=u[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(z){z(a,d,b)}throw null}
var H;function I(){if(!H){H=true;var a=m.createElement(wb);a.src=xb;a.id=P;a.style.cssText=yb;a.tabIndex=-1;m.body.appendChild(a);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:zb});a.contentWindow.location.replace(s+K)}}
v[Ab]=function(){var a=navigator.userAgent.toLowerCase();if(a.indexOf(Bb)!=-1)return Bb;if(a.indexOf(Cb)!=-1)return Cb;if(a.indexOf(Db)!=-1){if(a.indexOf(Eb)!=-1)return Fb;if(a.indexOf(Gb)!=-1)return Hb;if(a.indexOf(Ib)!=-1)return Jb;return Kb}if(a.indexOf(Lb)!=-1){if(a.indexOf(Mb)!=-1)return Nb;if(a.indexOf(Ob)!=-1)return Pb;return Qb}if(a.indexOf(Rb)!=-1){if(a.indexOf(Sb)!=-1)return Tb;return Ub}if(a.indexOf(Vb)!=-1)return Wb;return null};u[Ab]={air:0,chrome:1,gecko1_8:2,gecko1_9:3,ie6:4,ie7:5,ie8:6,ie9:7,opera:8,safari3:9,safari4:10,safari5:11};v[Xb]=function(){var c=navigator.userAgent.toLowerCase();var d=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return c.indexOf(Cb)!=-1}())return Cb;if(function(){return c.indexOf(Yb)!=-1||function(){if(c.indexOf(Zb)!=-1){return true}if(typeof window[$b]!=eb){try{var b=new ActiveXObject(_b);if(b){b.registerBhoIfNeeded();return true}}catch(a){}}return false}()}())return Lb;if(function(){return c.indexOf(Db)!=-1&&m.documentMode>=9}())return Kb;if(function(){return c.indexOf(Db)!=-1&&m.documentMode>=8}())return Jb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(c);if(a&&a.length==3)return d(a)>=6000}())return Fb;if(function(){return c.indexOf(Rb)!=-1}())return Tb;return ac};u[Xb]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};v[bc]=function(){var a=l.navigator.userAgent.toLowerCase();if(a.indexOf(cc)!=-1||a.indexOf(dc)!=-1){return ec}if(a.indexOf(fc)!=-1){return fc}if(a.indexOf(gc)!=-1||a.indexOf(hc)!=-1){return gc}return ac};u[bc]={linux:0,mac:1,windows:2};com_heva_ui_Main.onScriptLoad=function(){if(H){q=true;B()}};com_heva_ui_Main.onInjectionDone=function(){p=true;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:ic,millis:(new Date).getTime(),type:X});B()};D();C();var J;var K;if(A()){if(l.external&&(l.external.initModule&&l.external.initModule(P))){l.location.reload();return}K=jc;J=O}n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:kc});if(!A()){try{F([Cb,Cb,fc],lc);F([Cb,Cb,ec],lc+mc);F([Cb,Cb,gc],lc+nc);F([Wb,Lb,fc],oc);F([Wb,Lb,ec],oc+mc);F([Pb,Lb,ec],oc+pc);F([Pb,Lb,gc],oc+qc);F([Qb,Lb,fc],oc+rc);F([Qb,Lb,ec],oc+sc);F([Qb,Lb,gc],oc+tc);F([Wb,Lb,gc],oc+nc);F([Bb,Lb,fc],oc+uc);F([Bb,Lb,ec],oc+vc);F([Bb,Lb,gc],oc+wc);F([Nb,Lb,fc],oc+xc);F([Nb,Lb,ec],oc+yc);F([Nb,Lb,gc],oc+zc);F([Pb,Lb,fc],oc+Ac);F([Jb,Jb,fc],Bc);F([Jb,Jb,ec],Bc+mc);F([Jb,Jb,gc],Bc+nc);F([Kb,Kb,fc],Cc);F([Kb,Kb,ec],Cc+mc);F([Kb,Kb,gc],Cc+nc);F([Tb,Tb,fc],Dc);F([Tb,Tb,ec],Dc+mc);F([Tb,Tb,gc],Dc+nc);F([Ub,Tb,fc],Dc+uc);F([Ub,Tb,ec],Dc+vc);F([Ub,Tb,gc],Dc+wc);F([Fb,Fb,fc],Ec);F([Fb,Fb,ec],Ec+mc);F([Fb,Fb,gc],Ec+nc);F([Hb,Fb,fc],Ec+uc);F([Hb,Fb,ec],Ec+vc);F([Hb,Fb,gc],Ec+wc);J=w[G(Ab)][G(Xb)][G(bc)];var L=J.indexOf(Fc);if(L!=-1){x=Number(J.substring(L+1));J=J.substring(0,L)}K=J+Gc}catch(a){return}}var M;function N(){if(!r){r=true;B();if(m.removeEventListener){m.removeEventListener(Hc,N,false)}if(M){clearInterval(M)}}}
if(m.addEventListener){m.addEventListener(Hc,function(){I();N()},false)}var M=setInterval(function(){if(/loaded|complete/.test(m.readyState)){I();N()}},50);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:X});n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:ic,millis:(new Date).getTime(),type:S});m.write(Ic)}
com_heva_ui_Main();