package com.spring.example.repository.repositories.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.spring.example.repository.repositories.SequenceRepository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {

    @Autowired
    private MongoOperations mongoOperations;

    @Data
    @Document
    private class CustomSequence {
        @Id
        private String id;
        public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Long getSeq() {
			return seq;
		}
		public void setSeq(Long seq) {
			this.seq = seq;
		}
		private Long seq;
    }

    public Long getNextSequence(String seqName) {
        CustomSequence counter = mongoOperations.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class
        );
        return counter.getSeq();
    }
}
