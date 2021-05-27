'user script';
let arrowup__btn = document.querySelector('.arrowup__btn');
let header__logo = document.querySelector('.header__logo');

    //arrowup버튼
arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})

const container__board__listview = document.querySelector('.container__board__listview');
const container__board__paging = document.querySelector('.container__board__paging');
$(document).ready(function(){
    getBoardList();
});
    // 게시글 AJAX
    function getBoardList(){
        
        $.ajax({            
            type:'GET',
            url:'bulletin/listView',
            dataType:'JSON',

            success : function(obj) {
                console.log('성공');
     
                getBoardListCallback(obj);                
            },           
            error : function(xhr, status, error) {}
         });
    }

    const index__Paging = document.querySelector('.index__Paging');
    //페이징
container__board__paging.addEventListener('click',(e)=>{
    const targetid = e.target.dataset.id;
    const target = e.target;

   
  

    if(targetid)
    {
       
        $.ajax({            
            type:'GET',
            url:'bulletin/listView',
            data :{
            page : targetid
            },
            dataType:'JSON',
            success : function(obj) {
                console.log('검색성공');
                getBoardListCallback(obj);
                target.classList.add('now__paging');
                     
            },           
            error : function(xhr, status, error) {
                console.log('검색실패');
            }
            });
            
    }
    target.classList.add('now__paging'); 
})

const container__subTitle__btn = document.querySelector('.container__subTitle__btn');

container__subTitle__btn.addEventListener('click', ()=>{
    $.ajax({            
        type:'GET',
        url:'bulletin/listView',
        data :{   
        keyword : $('.container__subTitle__text').val(),
        clsfcselect : $('.container__subTitle__select').val()},
        dataType:'JSON',
        success : function(obj) {
            console.log('검색성공');
            
            getBoardListCallback(obj);                
        },           
        error : function(xhr, status, error) {
            console.log('검색실패');
        }
        });


})


const container__subTitle__text = document.querySelector('.container__subTitle__text');
container__subTitle__text.addEventListener('keyup',()=>{
    $.ajax({            
        type:'GET',
        url:'bulletin/listView',
        data :{
    keyword : $('.container__subTitle__text').val(),
    clsfcselect : $('.container__subTitle__select').val()
},
        dataType:'JSON',
        success : function(obj) {
            console.log('검색성공');
            console.log($('.container__subTitle__select').val());
            getBoardListCallback(obj);                
        },           
        error : function(xhr, status, error) {}
        });

})


//게시글 불러오기 
function getBoardListCallback(obj){
	 const container__board__listview =document.querySelector('.container__board__listview');
    container__board__listview.innerHTML='';    
    container__board__paging.innerHTML='';
    let list = obj;
    let listLen = list.list.length


   if(listLen >  0){
   
        for(let i=0; i<listLen; i++){
            let bltNo           = list.list[i].bltNo;
            let bltTitle        = list.list[i].bltTitle; 
            let bltType         = list.list[i].bltType; 
            let bltDate         = list.list[i].bltDate; 
            let bltLike     = list.list[i].bltLike; 
            let bltCnt     = list.list[i].bltCnt; 
            let memberName     = list.list[i].memberName; 
            const itemRow =document.createElement('li');
            itemRow.setAttribute('class','item__row');
            bltType= bltTypeSelector(bltType);
            itemRow.innerHTML=`
            <div class="container__board__list">
            <span class="container__board__type">${bltType}</span>
            <span class="container__board__title"><a href="bulletin/contentView?bltNo=${bltNo}">${bltTitle}</a> </span>
            <span class="container__board__writer">${memberName}</span>
            <span class="container__board__date">${bltDate}</span>
            <span class="container__board__cnt"><i class="fas fa-eye"></i>${bltCnt}</span>
            <span class="container__board__like"><i class="fas fa-grin-hearts"></i>${bltLike}</span></div>`;  
            
            container__board__listview.appendChild(itemRow);
        } 

        if(list.pagemaker.prev==true){

            const firstPage = list.pagemaker.startPage - 1;
            const prevBtn = document.createElement('p');
            prevBtn.setAttribute('class','index__Paging');
            prevBtn.setAttribute('data-id',`${firstPage}`);
            prevBtn.innerHTML='이전';
            container__board__paging.appendChild(prevBtn);
        }
     


        for(let i=list.pagemaker.startPage; i<=list.pagemaker.endPage; i++){

         //현재 페이지
            if(i===list.pagemaker.cri.page){
                const pagingBtn = document.createElement('p');
                pagingBtn.setAttribute('class','index__Paging__now');
                pagingBtn.setAttribute('data-id',`${i}`);
                pagingBtn.innerHTML+=`${i}`;
                container__board__paging.appendChild(pagingBtn);
            }
            else{
                const pagingBtn = document.createElement('p');
                pagingBtn.setAttribute('class','index__Paging');
                pagingBtn.setAttribute('data-id',`${i}`);
                pagingBtn.innerHTML+=`${i}`;
                container__board__paging.appendChild(pagingBtn);
                
            }
           
            
            
        }
        if(list.pagemaker.next==true){
            const lastPage = list.pagemaker.endPage + 1;
            const nextBtn = document.createElement('p');
            nextBtn.setAttribute('class','index__Paging');
            nextBtn.setAttribute('data-id',`${lastPage}`);
            nextBtn.innerHTML='다음';
            container__board__paging.appendChild(nextBtn);
        }
        }
        else if(listLen==0){
            container__board__paging.innerHTML='';
            container__board__listview.innerHTML='';
        console.log('게시글이없습니다.');
        }
       
    
}

function bltTypeSelector(obj){
    let type;
    if(obj==='free')
            {
                type='자유';
            }
            else if(obj==='qna')
            {
                type='질문';
            }
            else{
                type='구직';
            }
    return type;
}

