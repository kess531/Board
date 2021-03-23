'user script';
const arrowup__btn = document.querySelector('.arrowup__btn');
const header__logo = document.querySelector('.header__logo');

arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})

   
const container__board = document.querySelector('.container__board');
$(document).ready(function(){
    getBoardList();
});

    function getBoardList(){
        
        $.ajax({            
            type:'GET',
            url:'${pageContext.request.contextPath}/bulletin/listView',
            dataType:'JSON',
            success : function(obj) {
                console.log('성공');
                getBoardListCallback(obj);                
            },           
            error : function(xhr, status, error) {}
         });
    }
    
    function getBoardListCallback(obj){
        
        var list = obj;
        var listLen = list.list.length
        console.log(list);
        console.log(list.list.length);
       if(listLen >  0){
            
            for(let i=0; i<listLen; i++){
                
                var bltTitle        = list.list[i].bltTitle; 
                var bltContent         = list.list[i].bltContent; 
                var bltType         = list.list[i].bltType; 
                var bltDate         = list.list[i].bltDate; 
                var bltLike     = list.list[i].bltLike; 
                var bltCnt     = list.list[i].bltCnt; 
                var memberName     = list.list[i].memberName; 
                const itemRow =document.createElement('div');
                itemRow.setAttribute('class','container__board__list');
                itemRow.innerHTML=`
                <span class="container__board__title">
                <span class="container__board__type">${bltType}</span>
                <a href="contentview">${bltTitle}</a> </span>
            <span class="container__board__writer">${memberName}</span>
            <span class="container__board__date">${bltDate}</span>
            <span class="container__board__cnt"><i class="fas fa-eye"></i>${bltCnt}</span>
            <span class="container__board__like"><i class="fas fa-grin-hearts"></i>${bltLike}</span>`; 
            } 
            
        } else {
            
            console.log('게시글이없다');
        }
        
        container__board.appendChild(itemRow);
    }