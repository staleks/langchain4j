package dev.langchain4j.model.bedrock;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.bedrock.internal.BedrockEmbeddingResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Bedrock Cohere embedding response
 */
class BedrockCohereEmbeddingResponse implements BedrockEmbeddingResponse {

    private String id;

    private List<String> texts;

    private float[][] embeddings;

    @Override
    public List<Embedding> toEmbeddings() {
        if (embeddings == null) {
            return List.of();
        }
        return Arrays.stream(embeddings)
            .map(Embedding::from)
            .toList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    public float[][] getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(float[][] embeddings) {
        this.embeddings = embeddings;
    }

    @Override
    public Optional<Integer> getInputTextTokenCount() {
        return Optional.empty();
    }

}
