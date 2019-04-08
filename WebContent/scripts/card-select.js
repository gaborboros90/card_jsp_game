$(function() {
    'use strict';

     var labels = {
            cardSelect: 'Please select a card...',
            categorySelect: 'Please select a category...',
            callForFight: 'Let\'s fight with the enemy',
            nextRound: 'Next round',
            action: 'Action'
        },
        isPlayerAttackRound = true,
        $infoTitle = $('.info-container .page-title'),
        $selectedCategory = $('.selected-category-info'),
        $playerScore = $('.player-result-container h3 strong'),
        $computerScore = $('.computer-result-container h3 strong'),
        $playerInfoContainer = $('.player-result-container'),
        $computerInfoContainer = $('.computer-result-container'),
        $unknownPlayerCard = $('.player-result-container .card').clone(),
        $unknownComputerCard = $('.computer-result-container .card').clone(),
        $actionButton = $('.do-action-button'),
        $cardDisableContainer = $('.disable-cards'),
        selectedCardName = null,
        selectedCategoryName = null;

    $infoTitle.text(labels.cardSelect);

    $('.cards-container .card').on('click', function () {
        var selectedCardIndex = $(this).index(),
            slideSpeed = 'fast';

        if($(this).is(':animated')) {
            return;
        }

        $('.cards-container .card .categories').each($.proxy(function(index, element) {
            index !== selectedCardIndex - 1 && $(element).slideUp(slideSpeed);
        }, this));

        if(isPlayerAttackRound) {
            $(this).find('.categories').slideToggle(slideSpeed, $.proxy(function() {
                if($(this).find('.categories').is(':visible')) {
                    moveCardToInfoPanel($(this));

                    updateTextAndData(labels.categorySelect, '');
                    selectedCardName = $(this).find('.card-title').text();
                }
                else {
                    updateTextAndData(labels.cardSelect, '');

                    resetSelection();
                }
            }, this));
        }
        else {
            moveCardToInfoPanel($(this));
            $infoTitle.text(labels.callForFight);
            selectedCardName = $(this).find('.card-title').text();
        }
    });

    $('.cards-container .card .categories li').on('click', function (event) {
        event.stopImmediatePropagation();
        updateTextAndData(labels.callForFight, $(this).text());
    });

    $actionButton.on('click', function(event) {
    	if($(this).text() === labels.nextRound) {
    		prepareForNextRound();
    		
    		return;
    	}
    	
    	if(!selectedCategoryName) {
            return;
        }
    	
        var $loadingIndicator  = $('.loading-indicator-container');
        
        event.preventDefault();
        
        $loadingIndicator.show();

        $.ajax({
            method: 'POST',
            url: 'game-play',
            data: getRequestObject(),   
            dataType: 'JSON',
            success: function(data) {
            	setTimeout(function() {
            		parseResult(data);
                    $loadingIndicator.hide();
            	}, Math.floor(Math.random() * 500) + 1000);       
            }
        });
    });
    
    function prepareForNextRound () {
    	$actionButton.text(labels.action);
    	$cardDisableContainer.removeClass('flex');
    	resetSelection();
    	
    	if(!isPlayerAttackRound) {
    		var categoryNames = ["Speed","Attack","Deffence","Shooting"];
    		updateTextAndData(labels.cardSelect, categoryNames[Math.floor(Math.random() * 4)]);
    	}
    }

    function resetSelection() {
    	$playerInfoContainer.find('.card').replaceWith($unknownPlayerCard);
    	$computerInfoContainer.find('.card-title').text('Computer\'s card');
    	$computerInfoContainer.find('img').attr('src','images/unknown-card.png');
    	$computerInfoContainer.find('.speed').text('n/a');
    	$computerInfoContainer.find('.attack').text('n/a');
    	$computerInfoContainer.find('.deffence').text('n/a');
    	$computerInfoContainer.find('.shooting').text('n/a');
    	
        selectedCardName = null;
        selectedCategoryName = null;
        $selectedCategory.text('');
    }

    function updateTextAndData (playerInfoText, currentlySelectedCategory) {
        $selectedCategory.text(currentlySelectedCategory);
        selectedCategoryName = currentlySelectedCategory;
        $infoTitle.text(playerInfoText);
    }

    function moveCardToInfoPanel($card) {
        var $selectedClonedCard = $card.clone();
        $selectedClonedCard.find('.categories').hide();
        $playerInfoContainer.find('.card').replaceWith($selectedClonedCard);
    }

    function getRequestObject() {
        return {
            category: selectedCategoryName,
            cardName: selectedCardName
        };
    }

    function parseResult(data) {
    	if(data.isGameEnded) {
    		window.location.replace("result-page.jsp");
    	}
    	
    	isPlayerAttackRound = data.winnerName !== 'Computer';
    	
    	$actionButton.text(labels.nextRound);
    	updateTextAndData(data.winnerName + ' has won the round. Play next round', selectedCategoryName);
    	$computerScore.text(data.computerScore);
    	$playerScore.text(data.playerScore);
    	$computerInfoContainer.find('.card-title').text(data.computerCard.name);
    	$computerInfoContainer.find('img').attr('src','images/'+ data.computerCard.imageUrl);
    	$computerInfoContainer.find('.speed').text(data.computerCard.speed);
    	$computerInfoContainer.find('.attack').text(data.computerCard.attack);
    	$computerInfoContainer.find('.deffence').text(data.computerCard.deffence);
    	$computerInfoContainer.find('.shooting').text(data.computerCard.shooting);
    	
    	$('.cards-container .card').each(function(index,element) {
    		if($(element).find('.card-title').text() === selectedCardName) {
    			$(element).remove();
    		}
    	});
    	
    	$cardDisableContainer.addClass('flex');
    }
});