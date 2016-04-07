<h2><?php echo $title; ?></h2>

<?php foreach ($timeline as $timeline_item): ?>

    <h3><?php echo $timeline_item['title']; ?></h3>
    <div class="main">
        <?php echo $timeline_item['text']; ?>
    </div>
    <p><a href="<?php echo site_url('timeline/'.$timeline_item['slug']); ?>">View article</a></p>

<?php endforeach; ?>